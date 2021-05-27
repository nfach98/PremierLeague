package com.nfach98.premierleague.core.data

import com.nfach98.premierleague.core.data.source.local.LocalDataSource
import com.nfach98.premierleague.core.data.source.remote.RemoteDataSource
import com.nfach98.premierleague.core.data.source.remote.network.ApiResponse
import com.nfach98.premierleague.core.data.source.remote.response.*
import com.nfach98.premierleague.core.domain.model.*
import com.nfach98.premierleague.core.domain.repository.ILeagueRepository
import com.nfach98.premierleague.core.utils.AppExecutors
import com.nfach98.premierleague.core.utils.DataMapper
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LeagueRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ILeagueRepository {

    override fun getAllTable(): Flowable<Resource<List<Table>>> =
        object : NetworkBoundResource<List<Table>, List<TableResponse>>(appExecutors) {
            override fun loadFromDB(): Flowable<List<Table>> {
                return localDataSource.getAllTable().map { DataMapper.mapTableEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Table>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): Flowable<ApiResponse<List<TableResponse>>> =
                remoteDataSource.getAllTable()

            override fun saveCallResult(data: List<TableResponse>) {
                val tourismList = DataMapper.mapTableResponsesToEntities(data)
                localDataSource.insertTable(tourismList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()

    override fun getAllMatches(): Flowable<Resource<List<Match>>> =
        object : NetworkBoundResource<List<Match>, List<MatchResponse>>(appExecutors) {
            override fun loadFromDB(): Flowable<List<Match>> {
                return localDataSource.getAllMatches().map { DataMapper.mapMatchEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Match>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): Flowable<ApiResponse<List<MatchResponse>>> =
                remoteDataSource.getAllMatches()

            override fun saveCallResult(data: List<MatchResponse>) {
                val tourismList = DataMapper.mapMatchResponsesToEntities(data)
                localDataSource.insertMatch(tourismList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()

    override fun getMatch(id: String): Flowable<Resource<List<Match>>> =
        object : NetworkBoundResource<List<Match>, List<MatchResponse>>(appExecutors) {
            override fun loadFromDB(): Flowable<List<Match>> {
                return localDataSource.getMatch(id).map { DataMapper.mapMatchEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Match>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): Flowable<ApiResponse<List<MatchResponse>>> =
                remoteDataSource.getMatch(id)

            override fun saveCallResult(data: List<MatchResponse>) {
                val matchList = DataMapper.mapMatchResponsesToEntities(data)
                localDataSource.insertMatch(matchList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()

    override fun getMatchTimeline(id: String): Flowable<Resource<List<Timeline>>> =
        object : NetworkBoundResource<List<Timeline>, List<TimelineResponse>>(appExecutors) {
            override fun loadFromDB(): Flowable<List<Timeline>> {
                return localDataSource.getMatchTimeline(id).map { DataMapper.mapTimelineEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Timeline>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): Flowable<ApiResponse<List<TimelineResponse>>> =
                remoteDataSource.getMatchTimeline(id)

            override fun saveCallResult(data: List<TimelineResponse>) {
                val timelineList = DataMapper.mapTimelineResponsesToEntities(data)
                localDataSource.insertTimeline(timelineList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()

    override fun getMatchweek(week: String): Flowable<Resource<List<Match>>> =
        object : NetworkBoundResource<List<Match>, List<MatchResponse>>(appExecutors) {
            override fun loadFromDB(): Flowable<List<Match>> {
                return localDataSource.getMatchweek(week).map { DataMapper.mapMatchEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Match>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): Flowable<ApiResponse<List<MatchResponse>>> =
                remoteDataSource.getMatchweek(week)

            override fun saveCallResult(data: List<MatchResponse>) {
                val matchList = DataMapper.mapMatchResponsesToEntities(data)
                localDataSource.insertMatch(matchList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()

    override fun getAllClubs(): Flowable<Resource<List<Club>>> =
        object : NetworkBoundResource<List<Club>, List<ClubResponse>>(appExecutors) {
            override fun loadFromDB(): Flowable<List<Club>> {
                return localDataSource.getAllClubs().map { DataMapper.mapClubEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Club>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): Flowable<ApiResponse<List<ClubResponse>>> =
                remoteDataSource.getAllClubs()

            override fun saveCallResult(data: List<ClubResponse>) {
                val teamList = DataMapper.mapClubResponsesToEntities(data)
                localDataSource.insertTeam(teamList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()

    override fun getFavoriteClubs(): Flowable<List<Club>> {
        return localDataSource.getFavoriteClubs().map {
            DataMapper.mapClubEntitiesToDomain(it)
        }
    }

    override fun getClub(id: String): Flowable<Resource<List<Club>>> =
        object : NetworkBoundResource<List<Club>, List<ClubResponse>>(appExecutors) {
            override fun loadFromDB(): Flowable<List<Club>> {
                return localDataSource.getClub(id).map { DataMapper.mapClubEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Club>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): Flowable<ApiResponse<List<ClubResponse>>> =
                remoteDataSource.getClub(id)

            override fun saveCallResult(data: List<ClubResponse>) {
                val teamList = DataMapper.mapClubResponsesToEntities(data)
                localDataSource.insertTeam(teamList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()

    override fun getEquipment(id: String): Flowable<Resource<List<Equipment>>> =
        object : NetworkBoundResource<List<Equipment>, List<EquipmentResponse>>(appExecutors) {
            override fun loadFromDB(): Flowable<List<Equipment>> {
                return localDataSource.getEquipment(id).map { DataMapper.mapEquipmentEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Equipment>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): Flowable<ApiResponse<List<EquipmentResponse>>> =
                remoteDataSource.getEquipment(id)

            override fun saveCallResult(data: List<EquipmentResponse>) {
                val equipmentList = DataMapper.mapEquipmentResponsesToEntities(data)
                localDataSource.insertEquipment(equipmentList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()

    override fun getSquad(id: String): Flowable<Resource<List<Player>>> =
        object : NetworkBoundResource<List<Player>, List<PlayerResponse>>(appExecutors) {
            override fun loadFromDB(): Flowable<List<Player>> {
                return localDataSource.getSquad(id).map { DataMapper.mapPlayerEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Player>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): Flowable<ApiResponse<List<PlayerResponse>>> =
                remoteDataSource.getSquad(id)

            override fun saveCallResult(data: List<PlayerResponse>) {
                val playerList = DataMapper.mapPlayerResponsesToEntities(data)
                localDataSource.insertPlayer(playerList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()

    override fun getPlayer(id: String): Flowable<Resource<List<Player>>> =
        object : NetworkBoundResource<List<Player>, List<PlayerResponse>>(appExecutors) {
            override fun loadFromDB(): Flowable<List<Player>> {
                return localDataSource.getPlayer(id).map { DataMapper.mapPlayerEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Player>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): Flowable<ApiResponse<List<PlayerResponse>>> =
                remoteDataSource.getPlayer(id)

            override fun saveCallResult(data: List<PlayerResponse>) {
                val playerList = DataMapper.mapPlayerResponsesToEntities(data)
                localDataSource.insertPlayer(playerList)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            }
        }.asFlowable()

    override fun getFavoritePlayers(): Flowable<List<Player>> {
        return localDataSource.getFavoritePlayers().map {
            DataMapper.mapPlayerEntitiesToDomain(it)
        }
    }

    override fun setFavoriteClub(club: Club, state: Boolean) {
        val clubEntity = DataMapper.mapClubDomainToEntity(club)
        appExecutors.diskIO().execute { localDataSource.setFavoriteClub(clubEntity, state) }
    }

    override fun setFavoritePlayer(player: Player, state: Boolean) {
        val playerEntity = DataMapper.mapPlayerDomainToEntity(player)
        appExecutors.diskIO().execute { localDataSource.setFavoritePlayer(playerEntity, state) }
    }
}