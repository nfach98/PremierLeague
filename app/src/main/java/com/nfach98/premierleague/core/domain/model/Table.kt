package com.nfach98.premierleague.core.domain.model

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Table(
    val idStanding: String? = null,
    val intRank: String? = null,
    val idTeam: String? = null,
    val strTeam: String? = null,
    val strTeamBadge: String? = null,
    val idLeague: String? = null,
    val strLeague: String? = null,
    val strSeason: String? = null,
    val strForm: String? = null,
    val strDescription: String? = null,
    val intPlayed: String? = null,
    val intWin: String? = null,
    val intLoss: String? = null,
    val intDraw: String? = null,
    val intGoalsFor: String? = null,
    val intGoalsAgainst: String? = null,
    val intGoalDifference: String? = null,
    val intPoints: String? = null,
    val dateUpdated: String? = null
) : Parcelable