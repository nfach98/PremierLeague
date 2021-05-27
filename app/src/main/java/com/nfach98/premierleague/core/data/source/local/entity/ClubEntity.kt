package com.nfach98.premierleague.core.data.source.local.entity


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams")
data class ClubEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTeam")
    var idTeam: String,

    @ColumnInfo(name = "idSoccerXML")
    var idSoccerXML: String? = null,

    @ColumnInfo(name = "idAPIfootball")
    var idAPIfootball: String? = null,

    @ColumnInfo(name = "intLoved")
    var intLoved: String? = null,

    @ColumnInfo(name = "strTeam")
    var strTeam: String? = null,

    @ColumnInfo(name = "strTeamShort")
    var strTeamShort: String? = null,

    @ColumnInfo(name = "strAlternate")
    var strAlternate: String? = null,

    @ColumnInfo(name = "intFormedYear")
    var intFormedYear: String? = null,

    @ColumnInfo(name = "strSport")
    var strSport: String? = null,

    @ColumnInfo(name = "strLeague")
    var strLeague: String? = null,

    @ColumnInfo(name = "idLeague")
    var idLeague: String? = null,

    @ColumnInfo(name = "strLeague2")
    var strLeague2: String? = null,

    @ColumnInfo(name = "idLeague2")
    var idLeague2: String? = null,

    @ColumnInfo(name = "strLeague3")
    var strLeague3: String? = null,

    @ColumnInfo(name = "idLeague3")
    var idLeague3: String? = null,

    @ColumnInfo(name = "strLeague4")
    var strLeague4: String? = null,

    @ColumnInfo(name = "idLeague4")
    var idLeague4: String? = null,

    @ColumnInfo(name = "strLeague5")
    var strLeague5: String? = null,

    @ColumnInfo(name = "idLeague5")
    var idLeague5: String? = null,

    @ColumnInfo(name = "strLeague6")
    var strLeague6: String? = null,

    @ColumnInfo(name = "idLeague6")
    var idLeague6: String? = null,

    @ColumnInfo(name = "strLeague7")
    var strLeague7: String? = null,

    @ColumnInfo(name = "idLeague7")
    var idLeague7: String? = null,

    @ColumnInfo(name = "strDivision")
    var strDivision: String? = null,

    @ColumnInfo(name = "strManager")
    var strManager: String? = null,

    @ColumnInfo(name = "strStadium")
    var strStadium: String? = null,

    @ColumnInfo(name = "strKeywords")
    var strKeywords: String? = null,

    @ColumnInfo(name = "strRSS")
    var strRSS: String? = null,

    @ColumnInfo(name = "strStadiumThumb")
    var strStadiumThumb: String? = null,

    @ColumnInfo(name = "strStadiumDescription")
    var strStadiumDescription: String? = null,

    @ColumnInfo(name = "strStadiumLocation")
    var strStadiumLocation: String? = null,

    @ColumnInfo(name = "intStadiumCapacity")
    var intStadiumCapacity: String? = null,

    @ColumnInfo(name = "strWebsite")
    var strWebsite: String? = null,

    @ColumnInfo(name = "strFacebook")
    var strFacebook: String? = null,

    @ColumnInfo(name = "strTwitter")
    var strTwitter: String? = null,

    @ColumnInfo(name = "strInstagram")
    var strInstagram: String? = null,

    @ColumnInfo(name = "strDescriptionEN")
    var strDescriptionEN: String? = null,

    @ColumnInfo(name = "strDescriptionDE")
    var strDescriptionDE: String? = null,

    @ColumnInfo(name = "strDescriptionFR")
    var strDescriptionFR: String? = null,

    @ColumnInfo(name = "strDescriptionCN")
    var strDescriptionCN: String? = null,

    @ColumnInfo(name = "strDescriptionIT")
    var strDescriptionIT: String? = null,

    @ColumnInfo(name = "strDescriptionJP")
    var strDescriptionJP: String? = null,

    @ColumnInfo(name = "strDescriptionRU")
    var strDescriptionRU: String? = null,

    @ColumnInfo(name = "strDescriptionES")
    var strDescriptionES: String? = null,

    @ColumnInfo(name = "strDescriptionPT")
    var strDescriptionPT: String? = null,

    @ColumnInfo(name = "strDescriptionSE")
    var strDescriptionSE: String? = null,

    @ColumnInfo(name = "strDescriptionNL")
    var strDescriptionNL: String? = null,

    @ColumnInfo(name = "strDescriptionHU")
    var strDescriptionHU: String? = null,

    @ColumnInfo(name = "strDescriptionNO")
    var strDescriptionNO: String? = null,

    @ColumnInfo(name = "strDescriptionIL")
    var strDescriptionIL: String? = null,

    @ColumnInfo(name = "strDescriptionPL")
    var strDescriptionPL: String? = null,

    @ColumnInfo(name = "strGender")
    var strGender: String? = null,

    @ColumnInfo(name = "strCountry")
    var strCountry: String? = null,

    @ColumnInfo(name = "strTeamBadge")
    var strTeamBadge: String? = null,

    @ColumnInfo(name = "strTeamJersey")
    var strTeamJersey: String? = null,

    @ColumnInfo(name = "strTeamLogo")
    var strTeamLogo: String? = null,

    @ColumnInfo(name = "strTeamFanart1")
    var strTeamFanart1: String? = null,

    @ColumnInfo(name = "strTeamFanart2")
    var strTeamFanart2: String? = null,

    @ColumnInfo(name = "strTeamFanart3")
    var strTeamFanart3: String? = null,

    @ColumnInfo(name = "strTeamFanart4")
    var strTeamFanart4: String? = null,

    @ColumnInfo(name = "strTeamBanner")
    var strTeamBanner: String? = null,

    @ColumnInfo(name = "strYoutube")
    var strYoutube: String? = null,

    @ColumnInfo(name = "strLocked")
    var strLocked: String? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)