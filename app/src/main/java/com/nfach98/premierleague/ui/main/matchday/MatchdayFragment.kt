package com.nfach98.premierleague.ui.main.matchday

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfach98.premierleague.core.data.Resource
import com.nfach98.premierleague.core.ui.main.matchday.MatchAdapter
import com.nfach98.premierleague.databinding.FragmentMatchdayBinding
import com.nfach98.premierleague.ui.detail.match.MatchActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MatchdayFragment : Fragment() {

    private val matchdayViewModel: MatchdayViewModel by viewModel()

    private var _binding: FragmentMatchdayBinding? = null
    private val binding get() = _binding!!
    private var week = 0

    private lateinit var matchAdapter : MatchAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMatchdayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            matchAdapter = MatchAdapter()

            matchAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, MatchActivity::class.java)
                intent.putExtra(MatchActivity.EXTRA_ID, selectedData.idEvent)
                startActivity(intent)
            }

            matchdayViewModel.week.observe(viewLifecycleOwner, { match ->
                if(match != null && match is Resource.Success){

                    val matchesWeek = match.data?.filter { m -> m.strStatus == "Not Started" && m.strPostponed == "no" }
                    week = if(matchesWeek?.size!! > 0) matchesWeek[0].intRound?.toInt()!!
                    else 38

                    checkMatchweek(week)

                    binding.btnPrev.setOnClickListener {
                        week = week.minus(1)
                        checkMatchweek(week)
                    }

                    binding.btnNext.setOnClickListener {
                        week = week.plus(1)
                        checkMatchweek(week)
                    }

                    loadMatchweek(week)
                }
            })

            with(binding.rvMatches) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = matchAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun checkMatchweek(matchWeek: Int) {
        when {
            matchWeek <= 1 -> {
                binding.btnPrev.visibility = View.INVISIBLE
            }
            matchWeek >= 38 -> {
                binding.btnNext.visibility = View.INVISIBLE
            }
            matchWeek in 2..37 -> {
                binding.btnPrev.visibility = View.VISIBLE
                binding.btnNext.visibility = View.VISIBLE
            }
        }

        binding.tvMatchweek.text = "Matchweek $matchWeek"
        loadMatchweek(matchWeek)
    }

    private fun loadMatchweek(matchWeek: Int){
        matchAdapter.setData(listOf())
        binding.loading.visibility = View.VISIBLE

        matchdayViewModel.getMatchweek(matchWeek.toString()).observe(viewLifecycleOwner, { matches ->
            if(matches != null) {
                when (matches) {
                    is Resource.Success -> {
                        matches.data?.map {
                            val home = matchdayViewModel.clubs?.filter { t -> t.idTeam == it.idHomeTeam }
                            val away = matchdayViewModel.clubs?.filter { t -> t.idTeam == it.idAwayTeam }

                            it.strHomeTeamShort = home?.get(0)?.strTeamShort
                            it.strHomeTeamBadge = home?.get(0)?.strTeamBadge

                            it.strAwayTeamShort = away?.get(0)?.strTeamShort
                            it.strAwayTeamBadge = away?.get(0)?.strTeamBadge
                        }
                        binding.loading.visibility = View.GONE
                        matchAdapter.setData(matches.data)
                    }
                    else -> {
                        binding.loading.visibility = View.VISIBLE
                    }
                }
            }
        })
    }
}