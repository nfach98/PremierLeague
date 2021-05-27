package com.nfach98.premierleague.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team_table")
data class TableEntity (
    @ColumnInfo(name = "draw")
    val draw: Int,

    @ColumnInfo(name = "goalsagainst")
    val goalsagainst: Int,

    @ColumnInfo(name = "goalsdifference")
    val goalsdifference: Int,

    @ColumnInfo(name = "goalsfor")
    val goalsfor: Int,

    @ColumnInfo(name = "loss")
    val loss: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "played")
    val played: Int,

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "teamid")
    val teamid: String,

    @ColumnInfo(name = "total")
    val total: Int,

    @ColumnInfo(name = "win")
    val win: Int
)