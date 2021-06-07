package com.nfach98.premierleague.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team_table")
data class TableEntity (
    @ColumnInfo(name = "idStanding")
    var idStanding: String? = null,

    @ColumnInfo(name = "intRank")
    var intRank: String? = null,

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTeam")
    var idTeam: String,

    @ColumnInfo(name = "strTeam")
    var strTeam: String? = null,

    @ColumnInfo(name = "strTeamBadge")
    var strTeamBadge: String? = null,

    @ColumnInfo(name = "idLeague")
    var idLeague: String? = null,

    @ColumnInfo(name = "strLeague")
    var strLeague: String? = null,

    @ColumnInfo(name = "strSeason")
    var strSeason: String? = null,

    @ColumnInfo(name = "strForm")
    var strForm: String? = null,

    @ColumnInfo(name = "strDescription")
    var strDescription: String? = null,

    @ColumnInfo(name = "intPlayed")
    var intPlayed: String? = null,

    @ColumnInfo(name = "intWin")
    var intWin: String? = null,

    @ColumnInfo(name = "intLoss")
    var intLoss: String? = null,

    @ColumnInfo(name = "intDraw")
    var intDraw: String? = null,

    @ColumnInfo(name = "intGoalsFor")
    var intGoalsFor: String? = null,

    @ColumnInfo(name = "intGoalsAgainst")
    var intGoalsAgainst: String? = null,

    @ColumnInfo(name = "intGoalDifference")
    var intGoalDifference: String? = null,

    @ColumnInfo(name = "intPoints")
    var intPoints: String? = null,

    @ColumnInfo(name = "dateUpdated")
    var dateUpdated: String? = null
)