package com.nfach98.premierleague.core.ui.main.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nfach98.premierleague.R
import com.nfach98.premierleague.ui.main.favorite.FavoritePlayerFragment
import com.nfach98.premierleague.ui.main.favorite.FavoriteClubFragment

class FavoritePagerAdapter (private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private var titles = intArrayOf()

    init {
        titles = intArrayOf(R.string.clubs, R.string.players)
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> FavoriteClubFragment()
            1 -> FavoritePlayerFragment()
            else -> throw Throwable("Unknown FavoritePagerAdapter Fragment: $position")
        }
    }

    override fun getPageTitle(position: Int): CharSequence = context.resources.getString(titles[position])

    override fun getCount(): Int = titles.size
}