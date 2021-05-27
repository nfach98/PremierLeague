package com.nfach98.premierleague.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListClubResponse (
    @field:SerializedName("teams")
    val clubs: List<ClubResponse>
)