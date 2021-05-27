package com.nfach98.premierleague.ui.detail.player

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.nfach98.premierleague.core.data.Resource
import com.nfach98.premierleague.core.domain.model.Club
import com.nfach98.premierleague.core.domain.model.Player
import com.nfach98.premierleague.core.domain.usecase.LeagueUseCase
import com.nfach98.premierleague.core.utils.DataClubs

class PlayerViewModel constructor(private val leagueUseCase: LeagueUseCase) : ViewModel() {
    fun getPlayer(id: String) : LiveData<Resource<List<Player>>> {
        return LiveDataReactiveStreams.fromPublisher(leagueUseCase.getPlayer(id))
    }

    fun setFavoritePlayer(player: Player, newStatus:Boolean) = leagueUseCase.setFavoritePlayer(player, newStatus)

    val clubs = DataClubs.listClub
}