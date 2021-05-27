package com.nfach98.premierleague.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTimelineResponse (
    @field:SerializedName("timeline")
    val timeline: List<TimelineResponse>
)