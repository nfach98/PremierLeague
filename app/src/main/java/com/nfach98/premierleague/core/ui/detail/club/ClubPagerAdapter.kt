package com.nfach98.premierleague.core.ui.detail.club

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nfach98.premierleague.R
import com.nfach98.premierleague.ui.detail.club.ClubOverviewFragment
import com.nfach98.premierleague.ui.detail.club.ClubSquadFragment

class ClubPagerAdapter (
    private val context: Context,
    private val id: String?,
    fm: FragmentManager
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    @StringRes
    private var titles = intArrayOf()

    init {
        titles = intArrayOf(R.string.overview, R.string.squad)
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> ClubOverviewFragment(id)
            1 -> ClubSquadFragment(id)
            else -> throw Throwable("Unknown FavoritePagerAdapter Fragment: $position")
        }
    }

    override fun getPageTitle(position: Int): CharSequence = context.resources.getString(titles[position])

    override fun getCount(): Int = titles.size
}