package com.nfach98.premierleague.ui.detail.club

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.nfach98.premierleague.core.data.Resource
import com.nfach98.premierleague.core.domain.model.Equipment
import com.nfach98.premierleague.core.domain.model.Player
import com.nfach98.premierleague.core.domain.model.Club
import com.nfach98.premierleague.core.domain.usecase.LeagueUseCase
import com.nfach98.premierleague.core.utils.DataClubs

class ClubViewModel constructor(private val leagueUseCase: LeagueUseCase) : ViewModel() {
    fun getClub(id: String) : LiveData<Resource<List<Club>>> {
        return LiveDataReactiveStreams.fromPublisher(leagueUseCase.getClub(id))
    }

    fun getEquipment(id: String) : LiveData<Resource<List<Equipment>>> {
        return LiveDataReactiveStreams.fromPublisher(leagueUseCase.getEquipment(id))
    }

    fun getSquad(id: String) : LiveData<Resource<List<Player>>> {
        return LiveDataReactiveStreams.fromPublisher(leagueUseCase.getSquad(id))
    }

    fun setFavoriteClub(club: Club, newStatus:Boolean) = leagueUseCase.setFavoriteClub(club, newStatus)
}