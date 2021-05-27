package com.nfach98.premierleague.core.domain.usecase

import com.nfach98.premierleague.core.domain.model.Club
import com.nfach98.premierleague.core.domain.model.Player
import com.nfach98.premierleague.core.domain.repository.ILeagueRepository

class LeagueInteractor constructor (private val leagueRepository: ILeagueRepository): LeagueUseCase {

    override fun getAllTable() = leagueRepository.getAllTable()

    override fun getAllMatches() = leagueRepository.getAllMatches()

    override fun getMatch(id: String) = leagueRepository.getMatch(id)

    override fun getMatchTimeline(id: String) = leagueRepository.getMatchTimeline(id)

    override fun getMatchweek(week: String) = leagueRepository.getMatchweek(week)

    override fun getAllClubs() = leagueRepository.getAllClubs()

    override fun getFavoriteClubs() = leagueRepository.getFavoriteClubs()

    override fun getClub(id: String) = leagueRepository.getClub(id)

    override fun getEquipment(id: String) = leagueRepository.getEquipment(id)

    override fun getSquad(id: String) = leagueRepository.getSquad(id)

    override fun getPlayer(id: String) = leagueRepository.getPlayer(id)

    override fun getFavoritePlayers() = leagueRepository.getFavoritePlayers()

    override fun setFavoriteClub(club: Club, state: Boolean) = leagueRepository.setFavoriteClub(club, state)

    override fun setFavoritePlayer(player: Player, state: Boolean) = leagueRepository.setFavoritePlayer(player, state)
}