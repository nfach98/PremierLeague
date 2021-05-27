package com.nfach98.premierleague.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTableResponse (
    @field:SerializedName("table")
    val table: List<TableResponse>
)