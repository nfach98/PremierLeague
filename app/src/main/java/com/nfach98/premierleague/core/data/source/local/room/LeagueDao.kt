package com.nfach98.premierleague.core.data.source.local.room

import androidx.room.*
import com.nfach98.premierleague.core.data.source.local.entity.*
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface LeagueDao {

    @Query("SELECT * FROM team_table")
    fun getAllTable(): Flowable<List<TableEntity>>

    @Query("SELECT * FROM matches")
    fun getAllMatches(): Flowable<List<MatchEntity>>

    @Query("SELECT * FROM matches WHERE idEvent = :id")
    fun getMatch(id: String): Flowable<List<MatchEntity>>

    @Query("SELECT * FROM timeline WHERE idEvent = :id")
    fun getMatchTimeline(id: String): Flowable<List<TimelineEntity>>

    @Query("SELECT * FROM matches WHERE intRound = :week")
    fun getMatchweek(week: String): Flowable<List<MatchEntity>>

    @Query("SELECT * FROM teams")
    fun getAllClubs(): Flowable<List<ClubEntity>>

    @Query("SELECT * FROM teams WHERE isFavorite = 1")
    fun getFavoriteClubs(): Flowable<List<ClubEntity>>

    @Query("SELECT * FROM teams WHERE idTeam = :id")
    fun getClub(id: String): Flowable<List<ClubEntity>>

    @Query("SELECT * FROM equipment WHERE idTeam = :id")
    fun getEquipment(id: String): Flowable<List<EquipmentEntity>>

    @Query("SELECT * FROM player WHERE idTeam = :id")
    fun getSquad(id: String): Flowable<List<PlayerEntity>>

    @Query("SELECT * FROM player WHERE idPlayer = :id")
    fun getPlayer(id: String): Flowable<List<PlayerEntity>>

    @Query("SELECT * FROM player WHERE isFavorite = 1")
    fun getFavoritePlayers(): Flowable<List<PlayerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTable(table: List<TableEntity>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMatch(match: List<MatchEntity>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTimeline(match: List<TimelineEntity>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClub(matches: List<ClubEntity>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEquipment(match: List<EquipmentEntity>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayer(player: List<PlayerEntity>): Completable

    @Update
    fun updateFavoriteClub(clubEntity: ClubEntity)

    @Update
    fun updateFavoritePlayer(playerEntity: PlayerEntity)
}