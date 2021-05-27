package com.nfach98.premierleague.ui.detail.club

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.nfach98.premierleague.R
import com.nfach98.premierleague.core.data.Resource
import com.nfach98.premierleague.core.ui.TeamPagerAdapter
import com.nfach98.premierleague.databinding.ActivityClubBinding
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel

class ClubActivity : AppCompatActivity() {

    private val clubViewModel: ClubViewModel by viewModel()

    private var _binding: ActivityClubBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val EXTRA_ID = "extra_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityClubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.home.setOnClickListener { finish() }
        binding.homeNoBg.setOnClickListener { finish() }

        val id = intent.getStringExtra(EXTRA_ID)

        val teamPagerAdapter = TeamPagerAdapter(
            this@ClubActivity,
            id,
            supportFragmentManager
        )
        binding.teamViewPager.adapter = teamPagerAdapter
        binding.teamTabs.setupWithViewPager(binding.teamViewPager)

        if (id != null) {
            clubViewModel.getTeam(id).observe(this, { team ->
                if(team != null){
                    when(team){
                        is Resource.Success -> {
                            val data = team.data?.get(0)

                            Picasso.get().load("${data?.strTeamBadge}/preview").into(binding.ivLogo)
                            Picasso.get().load(data?.strStadiumThumb).into(binding.ivBackground)

                            binding.tvTeam.text = data?.strAlternate
                            binding.tvStadium.text = data?.strStadium

                            var isFavorite = data!!.isFavorite
                            setFavorite(isFavorite)
                            binding.fabFavorite.setOnClickListener {
                                isFavorite = !isFavorite
                                clubViewModel.setFavoriteClub(data, isFavorite)
                                setFavorite(isFavorite)
                                if(isFavorite) Toast.makeText(this@ClubActivity, "${data.strTeam} has added to favorite clubs", Toast.LENGTH_SHORT).show()
                                else Toast.makeText(this@ClubActivity, "${data.strTeam} has removed from favorite clubs", Toast.LENGTH_SHORT).show()
                            }
                        }
                        else -> {

                        }
                    }
                }
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setFavorite(state: Boolean) {
        if (state) {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24))
        } else {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24))
        }
    }
}