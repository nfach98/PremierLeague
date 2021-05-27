package com.nfach98.premierleague.ui.detail.match

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.nfach98.premierleague.core.data.Resource
import com.nfach98.premierleague.core.domain.model.Match
import com.nfach98.premierleague.core.domain.model.Timeline
import com.nfach98.premierleague.core.domain.usecase.LeagueUseCase
import com.nfach98.premierleague.core.utils.DataClubs

class MatchViewModel constructor(private val leagueUseCase: LeagueUseCase) : ViewModel() {

    val table = LiveDataReactiveStreams.fromPublisher(leagueUseCase.getAllTable())

    val week = LiveDataReactiveStreams.fromPublisher(leagueUseCase.getAllMatches())

    fun getMatchweek(week: String) : LiveData<Resource<List<Match>>> {
        return LiveDataReactiveStreams.fromPublisher(leagueUseCase.getMatchweek(week))
    }

    fun getMatch(id: String) : LiveData<Resource<List<Match>>> {
        return LiveDataReactiveStreams.fromPublisher(leagueUseCase.getMatch(id))
    }

    fun getMatchTimeline(id: String) : LiveData<Resource<List<Timeline>>> {
        return LiveDataReactiveStreams.fromPublisher(leagueUseCase.getMatchTimeline(id))
    }

    val clubs = DataClubs.listClub
}