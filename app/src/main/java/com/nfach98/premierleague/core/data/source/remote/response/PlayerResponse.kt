package com.nfach98.premierleague.core.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class PlayerResponse(
    @SerializedName("idPlayer")
    var idPlayer: String,
    @SerializedName("idTeam")
    var idTeam: String? = null,
    @SerializedName("idTeam2")
    var idTeam2: String? = null,
    @SerializedName("idTeamNational")
    var idTeamNational: String? = null,
    @SerializedName("idSoccerXML")
    var idSoccerXML: String? = null,
    @SerializedName("idAPIfootball")
    var idAPIfootball: String? = null,
    @SerializedName("idPlayerManager")
    var idPlayerManager: String? = null,
    @SerializedName("strNationality")
    var strNationality: String? = null,
    @SerializedName("strPlayer")
    var strPlayer: String? = null,
    @SerializedName("strTeam")
    var strTeam: String? = null,
    @SerializedName("strTeam2")
    var strTeam2: String? = null,
    @SerializedName("strSport")
    var strSport: String? = null,
    @SerializedName("intSoccerXMLTeamID")
    var intSoccerXMLTeamID: String? = null,
    @SerializedName("dateBorn")
    var dateBorn: String? = null,
    @SerializedName("strNumber")
    var strNumber: String? = null,
    @SerializedName("dateSigned")
    var dateSigned: String? = null,
    @SerializedName("strSigning")
    var strSigning: String? = null,
    @SerializedName("strWage")
    var strWage: String? = null,
    @SerializedName("strOutfitter")
    var strOutfitter: String? = null,
    @SerializedName("strKit")
    var strKit: String? = null,
    @SerializedName("strAgent")
    var strAgent: String? = null,
    @SerializedName("strBirthLocation")
    var strBirthLocation: String? = null,
    @SerializedName("strDescriptionEN")
    var strDescriptionEN: String? = null,
    @SerializedName("strDescriptionDE")
    var strDescriptionDE: String? = null,
    @SerializedName("strDescriptionFR")
    var strDescriptionFR: String? = null,
    @SerializedName("strDescriptionCN")
    var strDescriptionCN: String? = null,
    @SerializedName("strDescriptionIT")
    var strDescriptionIT: String? = null,
    @SerializedName("strDescriptionJP")
    var strDescriptionJP: String? = null,
    @SerializedName("strDescriptionRU")
    var strDescriptionRU: String? = null,
    @SerializedName("strDescriptionES")
    var strDescriptionES: String? = null,
    @SerializedName("strDescriptionPT")
    var strDescriptionPT: String? = null,
    @SerializedName("strDescriptionSE")
    var strDescriptionSE: String? = null,
    @SerializedName("strDescriptionNL")
    var strDescriptionNL: String? = null,
    @SerializedName("strDescriptionHU")
    var strDescriptionHU: String? = null,
    @SerializedName("strDescriptionNO")
    var strDescriptionNO: String? = null,
    @SerializedName("strDescriptionIL")
    var strDescriptionIL: String? = null,
    @SerializedName("strDescriptionPL")
    var strDescriptionPL: String? = null,
    @SerializedName("strGender")
    var strGender: String? = null,
    @SerializedName("strSide")
    var strSide: String? = null,
    @SerializedName("strPosition")
    var strPosition: String? = null,
    @SerializedName("strCollege")
    var strCollege: String? = null,
    @SerializedName("strFacebook")
    var strFacebook: String? = null,
    @SerializedName("strWebsite")
    var strWebsite: String? = null,
    @SerializedName("strTwitter")
    var strTwitter: String? = null,
    @SerializedName("strInstagram")
    var strInstagram: String? = null,
    @SerializedName("strYoutube")
    var strYoutube: String? = null,
    @SerializedName("strHeight")
    var strHeight: String? = null,
    @SerializedName("strWeight")
    var strWeight: String? = null,
    @SerializedName("intLoved")
    var intLoved: String? = null,
    @SerializedName("strThumb")
    var strThumb: String? = null,
    @SerializedName("strCutout")
    var strCutout: String? = null,
    @SerializedName("strRender")
    var strRender: String? = null,
    @SerializedName("strBanner")
    var strBanner: String? = null,
    @SerializedName("strFanart1")
    var strFanart1: String? = null,
    @SerializedName("strFanart2")
    var strFanart2: String? = null,
    @SerializedName("strFanart3")
    var strFanart3: String? = null,
    @SerializedName("strFanart4")
    var strFanart4: String? = null,
    @SerializedName("strCreativeCommons")
    var strCreativeCommons: String? = null,
    @SerializedName("strLocked")
    var strLocked: String? = null
)