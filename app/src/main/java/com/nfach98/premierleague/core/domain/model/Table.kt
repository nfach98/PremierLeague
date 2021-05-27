package com.nfach98.premierleague.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Table(
    val draw: Int,
    val goalsagainst: Int,
    val goalsdifference: Int,
    val goalsfor: Int,
    val loss: Int,
    val name: String,
    var teamBadge: String? = null,
    val played: Int,
    val teamid: String,
    val total: Int,
    val win: Int
) : Parcelable