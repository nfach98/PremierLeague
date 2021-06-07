package com.nfach98.premierleague.core.data.source.remote.network

import com.nfach98.premierleague.BuildConfig
import com.nfach98.premierleague.core.data.source.remote.response.*
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("lookuptable.php?l=${BuildConfig.LEAGUE_ID}&s=${BuildConfig.SEASON_ID}")
    fun getTable(): Flowable<ListTableResponse>

    @GET("eventsseason.php?id=${BuildConfig.LEAGUE_ID}&s=${BuildConfig.SEASON_ID}")
    fun getAllMatches(): Flowable<ListMatchResponse>

    @GET("lookupevent.php")
    fun getMatch(@Query("id") id: String): Flowable<ListMatchResponse>

    @GET("lookuptimeline.php")
    fun getMatchTimeline(@Query("id") id: String): Flowable<ListTimelineResponse>

    @GET("eventsround.php?id=${BuildConfig.LEAGUE_ID}&s=${BuildConfig.SEASON_ID}")
    fun getMatchweek(@Query("r") week: String): Flowable<ListMatchResponse>

    @GET("search_all_teams.php?s=Soccer&c=England")
    fun getAllClubs(): Flowable<ListClubResponse>

    @GET("lookupteam.php")
    fun getClub(@Query("id") id: String): Flowable<ListClubResponse>

    @GET("lookupequipment.php")
    fun getEquipment(@Query("id") id: String): Flowable<ListEquipmentResponse>

    @GET("lookup_all_players.php")
    fun getSquad(@Query("id") id: String): Flowable<ListPlayerResponse>

    @GET("lookupplayer.php")
    fun getPlayer(@Query("id") id: String): Flowable<ListPlayerResponse>
}