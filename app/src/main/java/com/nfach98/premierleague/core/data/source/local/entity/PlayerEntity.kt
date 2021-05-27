package com.nfach98.premierleague.core.data.source.local.entity


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class PlayerEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idPlayer")
    var idPlayer: String,

    @ColumnInfo(name = "idTeam")
    var idTeam: String? = null,

    @ColumnInfo(name = "idTeam2")
    var idTeam2: String? = null,

    @ColumnInfo(name = "idTeamNational")
    var idTeamNational: String? = null,

    @ColumnInfo(name = "idSoccerXML")
    var idSoccerXML: String? = null,

    @ColumnInfo(name = "idAPIfootball")
    var idAPIfootball: String? = null,

    @ColumnInfo(name = "idPlayerManager")
    var idPlayerManager: String? = null,

    @ColumnInfo(name = "strNationality")
    var strNationality: String? = null,

    @ColumnInfo(name = "strPlayer")
    var strPlayer: String? = null,

    @ColumnInfo(name = "strTeam")
    var strTeam: String? = null,

    @ColumnInfo(name = "strTeam2")
    var strTeam2: String? = null,

    @ColumnInfo(name = "strSport")
    var strSport: String? = null,

    @ColumnInfo(name = "intSoccerXMLTeamID")
    var intSoccerXMLTeamID: String? = null,

    @ColumnInfo(name = "dateBorn")
    var dateBorn: String? = null,

    @ColumnInfo(name = "strNumber")
    var strNumber: String? = null,

    @ColumnInfo(name = "dateSigned")
    var dateSigned: String? = null,

    @ColumnInfo(name = "strSigning")
    var strSigning: String? = null,

    @ColumnInfo(name = "strWage")
    var strWage: String? = null,

    @ColumnInfo(name = "strOutfitter")
    var strOutfitter: String? = null,

    @ColumnInfo(name = "strKit")
    var strKit: String? = null,

    @ColumnInfo(name = "strAgent")
    var strAgent: String? = null,

    @ColumnInfo(name = "strBirthLocation")
    var strBirthLocation: String? = null,

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

    @ColumnInfo(name = "strSide")
    var strSide: String? = null,

    @ColumnInfo(name = "strPosition")
    var strPosition: String? = null,

    @ColumnInfo(name = "strCollege")
    var strCollege: String? = null,

    @ColumnInfo(name = "strFacebook")
    var strFacebook: String? = null,

    @ColumnInfo(name = "strWebsite")
    var strWebsite: String? = null,

    @ColumnInfo(name = "strTwitter")
    var strTwitter: String? = null,

    @ColumnInfo(name = "strInstagram")
    var strInstagram: String? = null,

    @ColumnInfo(name = "strYoutube")
    var strYoutube: String? = null,

    @ColumnInfo(name = "strHeight")
    var strHeight: String? = null,

    @ColumnInfo(name = "strWeight")
    var strWeight: String? = null,

    @ColumnInfo(name = "intLoved")
    var intLoved: String? = null,

    @ColumnInfo(name = "strThumb")
    var strThumb: String? = null,

    @ColumnInfo(name = "strCutout")
    var strCutout: String? = null,

    @ColumnInfo(name = "strRender")
    var strRender: String? = null,

    @ColumnInfo(name = "strBanner")
    var strBanner: String? = null,

    @ColumnInfo(name = "strFanart1")
    var strFanart1: String? = null,

    @ColumnInfo(name = "strFanart2")
    var strFanart2: String? = null,

    @ColumnInfo(name = "strFanart3")
    var strFanart3: String? = null,

    @ColumnInfo(name = "strFanart4")
    var strFanart4: String? = null,

    @ColumnInfo(name = "strCreativeCommons")
    var strCreativeCommons: String? = null,

    @ColumnInfo(name = "strLocked")
    var strLocked: String? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)