package com.nfach98.premierleague.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListEquipmentResponse (
    @field:SerializedName("equipment")
    val equipment: List<EquipmentResponse>
)