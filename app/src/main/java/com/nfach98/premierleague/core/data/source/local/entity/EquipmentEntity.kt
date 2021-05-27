package com.nfach98.premierleague.core.data.source.local.entity


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "equipment")
data class EquipmentEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idEquipment")
    var idEquipment: String = "",

    @ColumnInfo(name = "idTeam")
    var idTeam: String = "",

    @ColumnInfo(name = "date")
    var date: String = "",

    @ColumnInfo(name = "strSeason")
    var strSeason: String = "",

    @ColumnInfo(name = "strEquipment")
    var strEquipment: String = "",

    @ColumnInfo(name = "strType")
    var strType: String = "",

    @ColumnInfo(name = "strUsername")
    var strUsername: String = ""
)