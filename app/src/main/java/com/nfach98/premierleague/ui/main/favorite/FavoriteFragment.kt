package com.nfach98.premierleague.ui.main.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nfach98.premierleague.core.ui.FavoritePagerAdapter
import com.nfach98.premierleague.databinding.FragmentFavoriteBinding
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favoritePagerAdapter = FavoritePagerAdapter(
            requireActivity(),
            childFragmentManager
        )
        binding.favViewPager.adapter = favoritePagerAdapter
        binding.favTabs.setupWithViewPager(binding.favViewPager)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}