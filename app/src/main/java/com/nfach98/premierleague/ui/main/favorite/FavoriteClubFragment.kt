package com.nfach98.premierleague.ui.main.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nfach98.premierleague.core.ui.FavoriteClubAdapter
import com.nfach98.premierleague.databinding.FragmentFavoriteClubBinding
import com.nfach98.premierleague.ui.detail.club.ClubActivity
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteClubFragment : Fragment() {
    private val favoriteViewModel: FavoriteViewModel by viewModel()

    private var _binding: FragmentFavoriteClubBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFavoriteClubBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        if (activity != null) {
            val clubAdapter = FavoriteClubAdapter()

            clubAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, ClubActivity::class.java)
                intent.putExtra(ClubActivity.EXTRA_ID, selectedData.idTeam)
                startActivity(intent)
            }

            favoriteViewModel.favoriteClubs.observe(viewLifecycleOwner, { clubs ->
                clubAdapter.setData(clubs)
            })

            with(binding.rvClubs) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = clubAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}