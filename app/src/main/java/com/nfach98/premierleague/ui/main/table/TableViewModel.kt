package com.nfach98.premierleague.ui.main.table

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.nfach98.premierleague.core.domain.usecase.LeagueUseCase
import com.nfach98.premierleague.core.utils.DataClubs

class TableViewModel constructor(leagueUseCase: LeagueUseCase) : ViewModel() {

    val table = LiveDataReactiveStreams.fromPublisher(leagueUseCase.getAllTable())

    val clubs = DataClubs.listClub
}