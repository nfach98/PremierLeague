package com.nfach98.premierleague.core.domain.model

data class Player(
    var idPlayer: String,
    var idTeam: String? = null,
    var idTeam2: String? = null,
    var idTeamNational: String? = null,
    var idSoccerXML: String? = null,
    var idAPIfootball: String? = null,
    var idPlayerManager: String? = null,
    var strTeamBadge: String? = null,
    var strNationality: String? = null,
    var strPlayer: String? = null,
    var strTeam: String? = null,
    var strTeam2: String? = null,
    var strSport: String? = null,
    var intSoccerXMLTeamID: String? = null,
    var dateBorn: String? = null,
    var strNumber: String? = null,
    var dateSigned: String? = null,
    var strSigning: String? = null,
    var strWage: String? = null,
    var strOutfitter: String? = null,
    var strKit: String? = null,
    var strAgent: String? = null,
    var strBirthLocation: String? = null,
    var strDescriptionEN: String? = null,
    var strDescriptionDE: String? = null,
    var strDescriptionFR: String? = null,
    var strDescriptionCN: String? = null,
    var strDescriptionIT: String? = null,
    var strDescriptionJP: String? = null,
    var strDescriptionRU: String? = null,
    var strDescriptionES: String? = null,
    var strDescriptionPT: String? = null,
    var strDescriptionSE: String? = null,
    var strDescriptionNL: String? = null,
    var strDescriptionHU: String? = null,
    var strDescriptionNO: String? = null,
    var strDescriptionIL: String? = null,
    var strDescriptionPL: String? = null,
    var strGender: String? = null,
    var strSide: String? = null,
    var strPosition: String? = null,
    var strCollege: String? = null,
    var strFacebook: String? = null,
    var strWebsite: String? = null,
    var strTwitter: String? = null,
    var strInstagram: String? = null,
    var strYoutube: String? = null,
    var strHeight: String? = null,
    var strWeight: String? = null,
    var intLoved: String? = null,
    var strThumb: String? = null,
    var strCutout: String? = null,
    var strRender: String? = null,
    var strBanner: String? = null,
    var strFanart1: String? = null,
    var strFanart2: String? = null,
    var strFanart3: String? = null,
    var strFanart4: String? = null,
    var strCreativeCommons: String? = null,
    var strLocked: String? = null,
    val isFavorite: Boolean
)