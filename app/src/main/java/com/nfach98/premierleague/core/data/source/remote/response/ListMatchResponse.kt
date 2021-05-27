package com.nfach98.premierleague.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListMatchResponse (
    @field:SerializedName("events")
    val events: List<MatchResponse>
)