package com.nfach98.premierleague.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.nfach98.premierleague.core.data.Resource
import com.nfach98.premierleague.core.domain.model.Match
import com.nfach98.premierleague.core.domain.usecase.LeagueUseCase
import com.nfach98.premierleague.core.utils.DataClubs

class HomeViewModel constructor(private val leagueUseCase: LeagueUseCase) : ViewModel() {

    val table = LiveDataReactiveStreams.fromPublisher(leagueUseCase.getAllTable())

    val week = LiveDataReactiveStreams.fromPublisher(leagueUseCase.getAllMatches())

    fun getMatchweek(week: String) : LiveData<Resource<List<Match>>> {
        return LiveDataReactiveStreams.fromPublisher(leagueUseCase.getMatchweek(week))
    }

    val clubs = DataClubs.listClub
}