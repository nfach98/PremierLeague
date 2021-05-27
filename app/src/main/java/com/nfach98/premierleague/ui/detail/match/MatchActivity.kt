package com.nfach98.premierleague.ui.detail.match

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfach98.premierleague.core.data.Resource
import com.nfach98.premierleague.core.ui.HomeTableAdapter
import com.nfach98.premierleague.core.ui.MatchTimelineAdapter
import com.nfach98.premierleague.databinding.ActivityMatchBinding
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel

class MatchActivity : AppCompatActivity() {
    private val matchViewModel: MatchViewModel by viewModel()

    private var _binding: ActivityMatchBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.homeNoBg.setOnClickListener { finish() }

        val timelineAdapter = MatchTimelineAdapter(this@MatchActivity)
        val id = intent.getStringExtra(EXTRA_ID)

        if (id != null) {
            matchViewModel.getMatch(id).observe(this, { matches ->
                if(matches != null){
                    when(matches){
                        is Resource.Success -> {
                            val data = matches.data?.get(0)

                            val home = matchViewModel.clubs?.filter { t -> t.idTeam == data?.idHomeTeam }
                            val away = matchViewModel.clubs?.filter { t -> t.idTeam == data?.idAwayTeam }

                            data?.strHomeTeamShort = home?.get(0)?.strTeamShort
                            data?.strHomeTeamBadge = home?.get(0)?.strTeamBadge

                            data?.strAwayTeamShort = away?.get(0)?.strTeamShort
                            data?.strAwayTeamBadge = away?.get(0)?.strTeamBadge

                            Picasso.get()
                                .load("${data?.strThumb}/preview")
                                .into(binding.ivBackground)

                            Picasso.get()
                                .load("${data?.strHomeTeamBadge}/preview")
                                .into(binding.ivHome)

                            Picasso.get()
                                .load("${data?.strAwayTeamBadge}/preview")
                                .into(binding.ivAway)

                            binding.tvName.text = data?.strEvent
                            binding.tvHome.text = data?.strHomeTeamShort
                            binding.tvAway.text = data?.strAwayTeamShort
                            if(data?.intHomeScore != null && data.intHomeScore != "" && data?.intAwayScore != null && data.intAwayScore != "") {
                                binding.tvScore.text = "${data?.intHomeScore} - ${data?.intAwayScore}"
                            }
                            else{
                                binding.tvScore.text = data?.strTime?.substring(0, data.strTime.length - 3)
                            }
                        }
                        else -> {

                        }
                    }
                }
            })

            matchViewModel.getMatchTimeline(id).observe(this, { timelines ->
                if(timelines != null){
                    when(timelines){
                        is Resource.Success -> {
                            timelineAdapter.setData(timelines.data?.reversed())
                        }
                        else -> {

                        }
                    }
                }
            })

            with(binding.rvTimeline) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = timelineAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}