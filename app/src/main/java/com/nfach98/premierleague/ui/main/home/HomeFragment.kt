package com.nfach98.premierleague.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfach98.premierleague.core.data.Resource
import com.nfach98.premierleague.core.ui.MatchAdapter
import com.nfach98.premierleague.core.ui.HomeTableAdapter
import com.nfach98.premierleague.core.utils.DataClubs
import com.nfach98.premierleague.databinding.FragmentHomeBinding
import com.nfach98.premierleague.ui.detail.club.ClubActivity
import com.nfach98.premierleague.ui.detail.match.MatchActivity
import org.koin.android.viewmodel.ext.android.viewModel

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
                intent.putExtra(ClubActivity.EXTRA_ID, selectedData.teamid)
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
                            table.data?.map {
                                val team = DataClubs.listClub?.filter { t -> t.idTeam == it.teamid }
                                it.teamBadge = team?.get(0)?.strTeamBadge
                            }

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
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}