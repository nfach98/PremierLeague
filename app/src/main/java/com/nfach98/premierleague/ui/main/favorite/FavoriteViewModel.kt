package com.nfach98.premierleague.ui.main.favorite

import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.nfach98.premierleague.core.domain.usecase.LeagueUseCase
import com.nfach98.premierleague.core.utils.DataClubs

class FavoriteViewModel constructor(private val leagueUseCase: LeagueUseCase) : ViewModel() {
    val favoriteClubs = LiveDataReactiveStreams.fromPublisher(leagueUseCase.getFavoriteClubs())

    val favoritePlayers = LiveDataReactiveStreams.fromPublisher(leagueUseCase.getFavoritePlayers())

    val clubs = DataClubs.listClub
}