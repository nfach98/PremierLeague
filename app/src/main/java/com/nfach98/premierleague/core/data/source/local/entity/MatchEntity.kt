package com.nfach98.premierleague.core.data.source.local.entity


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches")
data class MatchEntity(
    @ColumnInfo(name = "dateEvent")
    var dateEvent: String? = null,

    @ColumnInfo(name = "dateEventLocal")
    var dateEventLocal: String? = null,

    @ColumnInfo(name = "idAPIfootball")
    var idAPIfootball: String? = null,

    @ColumnInfo(name = "idAwayTeam")
    var idAwayTeam: String? = null,

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idEvent")
    var idEvent: String,

    @ColumnInfo(name = "idHomeTeam")
    var idHomeTeam: String? = null,

    @ColumnInfo(name = "idLeague")
    var idLeague: String? = null,

    @ColumnInfo(name = "idSoccerXML")
    var idSoccerXML: String? = null,

    @ColumnInfo(name = "intAwayScore")
    var intAwayScore: String? = null,

    @ColumnInfo(name = "intAwayShots")
    var intAwayShots: String? = null,

    @ColumnInfo(name = "intHomeScore")
    var intHomeScore: String? = null,

    @ColumnInfo(name = "intHomeShots")
    var intHomeShots: String? = null,

    @ColumnInfo(name = "intRound")
    var intRound: String? = null,

    @ColumnInfo(name = "intSpectators")
    var intSpectators: String? = null,

    @ColumnInfo(name = "strAwayFormation")
    var strAwayFormation: String? = null,

    @ColumnInfo(name = "strAwayGoalDetails")
    var strAwayGoalDetails: String? = null,

    @ColumnInfo(name = "strAwayLineupDefense")
    var strAwayLineupDefense: String? = null,

    @ColumnInfo(name = "strAwayLineupForward")
    var strAwayLineupForward: String? = null,

    @ColumnInfo(name = "strAwayLineupGoalkeeper")
    var strAwayLineupGoalkeeper: String? = null,

    @ColumnInfo(name = "strAwayLineupMidfield")
    var strAwayLineupMidfield: String? = null,

    @ColumnInfo(name = "strAwayLineupSubstitutes")
    var strAwayLineupSubstitutes: String? = null,

    @ColumnInfo(name = "strAwayRedCards")
    var strAwayRedCards: String? = null,

    @ColumnInfo(name = "strAwayTeam")
    var strAwayTeam: String? = null,

    @ColumnInfo(name = "strAwayYellowCards")
    var strAwayYellowCards: String? = null,

    @ColumnInfo(name = "strBanner")
    var strBanner: String? = null,

    @ColumnInfo(name = "strCity")
    var strCity: String? = null,

    @ColumnInfo(name = "strCountry")
    var strCountry: String? = null,

    @ColumnInfo(name = "strDescriptionEN")
    var strDescriptionEN: String? = null,

    @ColumnInfo(name = "strEvent")
    var strEvent: String? = null,

    @ColumnInfo(name = "strEventAlternate")
    var strEventAlternate: String? = null,

    @ColumnInfo(name = "strFanart")
    var strFanart: String? = null,

    @ColumnInfo(name = "strFilename")
    var strFilename: String? = null,

    @ColumnInfo(name = "strHomeFormation")
    var strHomeFormation: String? = null,

    @ColumnInfo(name = "strHomeGoalDetails")
    var strHomeGoalDetails: String? = null,

    @ColumnInfo(name = "strHomeLineupDefense")
    var strHomeLineupDefense: String? = null,

    @ColumnInfo(name = "strHomeLineupForward")
    var strHomeLineupForward: String? = null,

    @ColumnInfo(name = "strHomeLineupGoalkeeper")
    var strHomeLineupGoalkeeper: String? = null,

    @ColumnInfo(name = "strHomeLineupMidfield")
    var strHomeLineupMidfield: String? = null,

    @ColumnInfo(name = "strHomeLineupSubstitutes")
    var strHomeLineupSubstitutes: String? = null,

    @ColumnInfo(name = "strHomeRedCards")
    var strHomeRedCards: String? = null,

    @ColumnInfo(name = "strHomeTeam")
    var strHomeTeam: String? = null,

    @ColumnInfo(name = "strHomeYellowCards")
    var strHomeYellowCards: String? = null,

    @ColumnInfo(name = "strLeague")
    var strLeague: String? = null,

    @ColumnInfo(name = "strLocked")
    var strLocked: String? = null,

    @ColumnInfo(name = "strMap")
    var strMap: String? = null,

    @ColumnInfo(name = "strOfficial")
    var strOfficial: String? = null,

    @ColumnInfo(name = "strPoster")
    var strPoster: String? = null,

    @ColumnInfo(name = "strPostponed")
    var strPostponed: String? = null,

    @ColumnInfo(name = "strResult")
    var strResult: String? = null,

    @ColumnInfo(name = "strSeason")
    var strSeason: String? = null,

    @ColumnInfo(name = "strSport")
    var strSport: String? = null,

    @ColumnInfo(name = "strSquare")
    var strSquare: String? = null,

    @ColumnInfo(name = "strStatus")
    var strStatus: String? = null,

    @ColumnInfo(name = "strTVStation")
    var strTVStation: String? = null,

    @ColumnInfo(name = "strThumb")
    var strThumb: String? = null,

    @ColumnInfo(name = "strTime")
    var strTime: String? = null,

    @ColumnInfo(name = "strTimeLocal")
    var strTimeLocal: String? = null,

    @ColumnInfo(name = "strTimestamp")
    var strTimestamp: String? = null,

    @ColumnInfo(name = "strTweet1")
    var strTweet1: String? = null,

    @ColumnInfo(name = "strTweet2")
    var strTweet2: String? = null,

    @ColumnInfo(name = "strTweet3")
    var strTweet3: String? = null,

    @ColumnInfo(name = "strVenue")
    var strVenue: String? = null,

    @ColumnInfo(name = "strVideo")
    var strVideo: String? = null
)