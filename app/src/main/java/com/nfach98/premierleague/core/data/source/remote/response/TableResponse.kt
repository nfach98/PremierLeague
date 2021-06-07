package com.nfach98.premierleague.core.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class TableResponse(
    @SerializedName("idStanding")
    var idStanding: String? = null,

    @SerializedName("intRank")
    var intRank: String? = null,

    @SerializedName("idTeam")
    var idTeam: String,

    @SerializedName("strTeam")
    var strTeam: String? = null,

    @SerializedName("strTeamBadge")
    var strTeamBadge: String? = null,

    @SerializedName("idLeague")
    var idLeague: String? = null,

    @SerializedName("strLeague")
    var strLeague: String? = null,

    @SerializedName("strSeason")
    var strSeason: String? = null,

    @SerializedName("strForm")
    var strForm: String? = null,

    @SerializedName("strDescription")
    var strDescription: String? = null,

    @SerializedName("intPlayed")
    var intPlayed: String? = null,

    @SerializedName("intWin")
    var intWin: String? = null,

    @SerializedName("intLoss")
    var intLoss: String? = null,

    @SerializedName("intDraw")
    var intDraw: String? = null,

    @SerializedName("intGoalsFor")
    var intGoalsFor: String? = null,

    @SerializedName("intGoalsAgainst")
    var intGoalsAgainst: String? = null,

    @SerializedName("intGoalDifference")
    var intGoalDifference: String? = null,

    @SerializedName("intPoints")
    var intPoints: String? = null,

    @SerializedName("dateUpdated")
    var dateUpdated: String? = null
)