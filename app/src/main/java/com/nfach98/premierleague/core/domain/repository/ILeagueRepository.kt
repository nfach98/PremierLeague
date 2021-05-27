package com.nfach98.premierleague.core.domain.repository

import com.nfach98.premierleague.core.data.Resource
import com.nfach98.premierleague.core.domain.model.*
import io.reactivex.Flowable

interface ILeagueRepository {
    fun getAllTable(): Flowable<Resource<List<Table>>>

    fun getAllMatches(): Flowable<Resource<List<Match>>>

    fun getMatch(id: String): Flowable<Resource<List<Match>>>

    fun getMatchTimeline(id: String): Flowable<Resource<List<Timeline>>>

    fun getMatchweek(week: String): Flowable<Resource<List<Match>>>

    fun getAllClubs(): Flowable<Resource<List<Club>>>

    fun getFavoriteClubs(): Flowable<List<Club>>

    fun getClub(id: String): Flowable<Resource<List<Club>>>

    fun getEquipment(id: String): Flowable<Resource<List<Equipment>>>

    fun getSquad(id: String): Flowable<Resource<List<Player>>>

    fun getPlayer(id: String): Flowable<Resource<List<Player>>>

    fun getFavoritePlayers(): Flowable<List<Player>>

    fun setFavoriteClub(club: Club, state: Boolean)

    fun setFavoritePlayer(player: Player, state: Boolean)
}