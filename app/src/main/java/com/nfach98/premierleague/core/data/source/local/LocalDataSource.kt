package com.nfach98.premierleague.core.data.source.local

import com.nfach98.premierleague.core.data.source.local.entity.*
import com.nfach98.premierleague.core.data.source.local.room.LeagueDao
import io.reactivex.Flowable

class LocalDataSource constructor(private val leagueDao: LeagueDao) {

    //RX
    fun getAllTable(): Flowable<List<TableEntity>> = leagueDao.getAllTable()

    fun getAllMatches(): Flowable<List<MatchEntity>> = leagueDao.getAllMatches()

    fun getMatch(id: String): Flowable<List<MatchEntity>> = leagueDao.getMatch(id)

    fun getMatchTimeline(id: String): Flowable<List<TimelineEntity>> = leagueDao.getMatchTimeline(id)

    fun getMatchweek(week: String): Flowable<List<MatchEntity>> = leagueDao.getMatchweek(week)

    fun getAllClubs(): Flowable<List<ClubEntity>> = leagueDao.getAllClubs()

    fun getFavoriteClubs(): Flowable<List<ClubEntity>> = leagueDao.getFavoriteClubs()

    fun getClub(id: String): Flowable<List<ClubEntity>> = leagueDao.getClub(id)

    fun getEquipment(id: String): Flowable<List<EquipmentEntity>> = leagueDao.getEquipment(id)

    fun getSquad(id: String): Flowable<List<PlayerEntity>> = leagueDao.getSquad(id)

    fun getPlayer(id: String): Flowable<List<PlayerEntity>> = leagueDao.getPlayer(id)

    fun getFavoritePlayers(): Flowable<List<PlayerEntity>> = leagueDao.getFavoritePlayers()

    fun insertTable(tableList: List<TableEntity>) = leagueDao.insertTable(tableList)

    fun insertMatch(matchList: List<MatchEntity>) = leagueDao.insertMatch(matchList)

    fun insertTimeline(timelineList: List<TimelineEntity>) = leagueDao.insertTimeline(timelineList)

    fun insertTeam(teamsList: List<ClubEntity>) = leagueDao.insertClub(teamsList)

    fun insertEquipment(equipmentList: List<EquipmentEntity>) = leagueDao.insertEquipment(equipmentList)

    fun insertPlayer(playerList: List<PlayerEntity>) = leagueDao.insertPlayer(playerList)

    fun setFavoriteClub(club: ClubEntity, newState: Boolean) {
        club.isFavorite = newState
        leagueDao.updateFavoriteClub(club)
    }

    fun setFavoritePlayer(player: PlayerEntity, newState: Boolean) {
        player.isFavorite = newState
        leagueDao.updateFavoritePlayer(player)
    }
}