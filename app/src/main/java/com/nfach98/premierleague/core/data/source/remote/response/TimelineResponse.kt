package com.nfach98.premierleague.core.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class TimelineResponse(
    @SerializedName("idTimeline")
    var idTimeline: String,
    @SerializedName("idEvent")
    var idEvent: String? = null,
    @SerializedName("strTimeline")
    var strTimeline: String? = null,
    @SerializedName("strTimelineDetail")
    var strTimelineDetail: String? = null,
    @SerializedName("strHome")
    var strHome: String? = null,
    @SerializedName("strEvent")
    var strEvent: String? = null,
    @SerializedName("idAPIfootball")
    var idAPIfootball: String? = null,
    @SerializedName("idPlayer")
    var idPlayer: String? = null,
    @SerializedName("strPlayer")
    var strPlayer: String? = null,
    @SerializedName("strCountry")
    var strCountry: String? = null,
    @SerializedName("idAssist")
    var idAssist: String? = null,
    @SerializedName("strAssist")
    var strAssist: String? = null,
    @SerializedName("intTime")
    var intTime: String? = null,
    @SerializedName("idTeam")
    var idTeam: String? = null,
    @SerializedName("strTeam")
    var strTeam: String? = null,
    @SerializedName("strComment")
    var strComment: String? = null,
    @SerializedName("dateEvent")
    var dateEvent: String? = null,
    @SerializedName("strSeason")
    var strSeason: String? = null
)