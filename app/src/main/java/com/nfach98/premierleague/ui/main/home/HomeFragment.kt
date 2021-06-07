package com.nfach98.premierleague.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfach98.premierleague.BuildConfig
import com.nfach98.premierleague.R
import com.nfach98.premierleague.core.data.Resource
import com.nfach98.premierleague.core.ui.main.matchday.MatchAdapter
import com.nfach98.premierleague.core.ui.main.home.HomeTableAdapter
import com.nfach98.premierleague.databinding.FragmentHomeBinding
import com.nfach98.premierleague.ui.detail.club.ClubActivity
import com.nfach98.premierleague.ui.detail.match.MatchActivity
import com.nfach98.premierleague.ui.detail.player.PlayerActivity
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel
import kotlin.random.Random

class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val matchAdapter = MatchAdapter()
            val tableAdapter = HomeTableAdapter()

            matchAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, MatchActivity::class.java)
                intent.putExtra(MatchActivity.EXTRA_ID, selectedData.idEvent)
                startActivity(intent)
            }

            tableAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, ClubActivity::class.java)
                intent.putExtra(ClubActivity.EXTRA_ID, selectedData.idTeam)
                startActivity(intent)
            }

            //matchweek
            homeViewModel.week.observe(viewLifecycleOwner, { match ->
                if(match != null && match is Resource.Success){
                    val matchesWeek = match.data?.filter { m -> m.strStatus == "Not Started" && m.strPostponed == "no" }
                    val week = if(matchesWeek?.size!! > 0) matchesWeek[0].intRound
                    else "38"

                    if (week != null) {
                        binding.tvMatchweek.text = "Matchweek $week"

                        homeViewModel.getMatchweek(week).observe(viewLifecycleOwner, { matches ->
                            if(matches != null) {
                                when (matches) {
                                    is Resource.Success -> {
                                        matches.data?.map {
                                            val home = homeViewModel.clubs?.filter { t -> t.idTeam == it.idHomeTeam }
                                            val away = homeViewModel.clubs?.filter { t -> t.idTeam == it.idAwayTeam }

                                            it.strHomeTeamShort = home?.get(0)?.strTeamShort
                                            it.strHomeTeamBadge = home?.get(0)?.strTeamBadge

                                            it.strAwayTeamShort = away?.get(0)?.strTeamShort
                                            it.strAwayTeamBadge = away?.get(0)?.strTeamBadge
                                        }

                                        binding.loading.visibility = View.GONE
                                        binding.titleMatchweek.visibility = View.VISIBLE
                                        binding.gradientMatchweek.visibility = View.VISIBLE
                                        matchAdapter.setData(matches.data)
                                    }
                                    else -> {
                                        binding.titleMatchweek.visibility = View.GONE
                                        binding.gradientMatchweek.visibility = View.GONE
                                    }
                                }
                            }
                        })
                    }
                }
            })

            //table
            homeViewModel.table.observe(viewLifecycleOwner, { table ->
                if (table != null) {
                    when (table) {
//                        is Resource.Loading -> binding.loading.visibility = View.VISIBLE
                        is Resource.Success -> {
//                            table.data?.map {
//                                val team = DataClubs.listClub?.filter { t -> t.idTeam == it.teamid }
//                                it.teamBadge = team?.get(0)?.strTeamBadge
//                            }

                            binding.loading.visibility = View.GONE
                            binding.gradientTable.visibility = View.VISIBLE
                            binding.titleTable.visibility = View.VISIBLE
                            binding.headerTable.visibility = View.VISIBLE
                            tableAdapter.setData(table.data?.take(5))
                        }
                        else -> {
                            binding.loading.visibility = View.VISIBLE
                            binding.titleMatchweek.visibility = View.GONE
                            binding.gradientMatchweek.visibility = View.GONE
                        }
                        /* is Resource.Error -> {
                             binding.loading.visibility = View.GONE
                             binding.viewError.root.visibility = View.VISIBLE
                             binding.viewError.tvError.text = tourism.message ?: getString(R.string.something_wrong)
                         }*/
                    }
                }
            })

            with(binding.rvMatchweek) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = matchAdapter
            }

            with(binding.rvTable) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tableAdapter
            }

            //player
            val clubs = homeViewModel.clubs?.filter { c -> c.idLeague == BuildConfig.LEAGUE_ID }
            val club = clubs?.get(Random.nextInt(clubs.size))
            club?.idTeam?.let {
                homeViewModel.getSquad(it).observe(viewLifecycleOwner, { squad ->
                    if (squad != null) {
                        when (squad) {
                            is Resource.Success -> {
                                val player = squad.data?.filter { p ->
                                    p.strPosition != "Manager"
                                }?.get(Random.nextInt(squad.data.size))

                                binding.loading.visibility = View.GONE
                                binding.gradientPlayer.visibility = View.VISIBLE
                                binding.titlePlayer.visibility = View.VISIBLE
                                binding.layoutPlayer.visibility = View.VISIBLE

                                binding.tvNamePlayer.text = player?.strPlayer
                                binding.tvTeamPlayer.text = player?.strTeam
                                binding.tvPositionPlayer.text = player?.strPosition

                                Picasso.get()
                                    .load("${club.strTeamBadge}/tiny")
                                    .into(binding.ivTeamPlayer)

                                Picasso.get()
                                    .load("${player?.strCutout}/preview")
                                    .placeholder(R.drawable.placeholder_player)
                                    .error(R.drawable.placeholder_player)
                                    .into(binding.ivPlayer)

                                binding.layoutPlayer.setOnClickListener {
                                    val intent = Intent(activity, PlayerActivity::class.java)
                                    intent.putExtra(PlayerActivity.EXTRA_ID, player?.idPlayer)
                                    startActivity(intent)
                                }
                            }
                            else -> {
                                binding.loading.visibility = View.VISIBLE
                                binding.gradientPlayer.visibility = View.GONE
                                binding.titlePlayer.visibility = View.GONE
                                binding.layoutPlayer.visibility = View.GONE
                            }
                        }
                    }
                })
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}