package com.nfach98.premierleague.core.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class EquipmentResponse(
    @SerializedName("idEquipment")
    var idEquipment: String = "",
    @SerializedName("idTeam")
    var idTeam: String = "",
    @SerializedName("date")
    var date: String = "",
    @SerializedName("strSeason")
    var strSeason: String = "",
    @SerializedName("strEquipment")
    var strEquipment: String = "",
    @SerializedName("strType")
    var strType: String = "",
    @SerializedName("strUsername")
    var strUsername: String = ""
)