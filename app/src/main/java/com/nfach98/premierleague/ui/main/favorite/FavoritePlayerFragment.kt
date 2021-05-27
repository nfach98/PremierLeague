package com.nfach98.premierleague.ui.main.favorite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfach98.premierleague.core.ui.FavoritePlayerAdapter
import com.nfach98.premierleague.databinding.FragmentFavoritePlayerBinding
import com.nfach98.premierleague.ui.detail.player.PlayerActivity
import org.koin.android.viewmodel.ext.android.viewModel

class FavoritePlayerFragment : Fragment() {
    private val favoriteViewModel: FavoriteViewModel by viewModel()

    private var _binding: FragmentFavoritePlayerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFavoritePlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        if (activity != null) {
            val playerAdapter = FavoritePlayerAdapter()

            playerAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, PlayerActivity::class.java)
                intent.putExtra(PlayerActivity.EXTRA_ID, selectedData.idPlayer)
                startActivity(intent)
            }

            favoriteViewModel.favoritePlayers.observe(viewLifecycleOwner, { players ->
                players.map {
                    val club = favoriteViewModel.clubs?.filter { t -> t.idTeam == it.idTeam }
                    it.strTeamBadge = club?.get(0)?.strTeamBadge
                }
                playerAdapter.setData(players)
            })

            with(binding.rvPlayers) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = playerAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}