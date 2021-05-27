package com.nfach98.premierleague.core.data.source.local.entity


import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "timeline")
data class TimelineEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "idTimeline")
    var idTimeline: String,
    @ColumnInfo(name = "idEvent")
    var idEvent: String? = null,
    @ColumnInfo(name = "strTimeline")
    var strTimeline: String? = null,
    @ColumnInfo(name = "strTimelineDetail")
    var strTimelineDetail: String? = null,
    @ColumnInfo(name = "strHome")
    var strHome: String? = null,
    @ColumnInfo(name = "strEvent")
    var strEvent: String? = null,
    @ColumnInfo(name = "idAPIfootball")
    var idAPIfootball: String? = null,
    @ColumnInfo(name = "idPlayer")
    var idPlayer: String? = null,
    @ColumnInfo(name = "strPlayer")
    var strPlayer: String? = null,
    @ColumnInfo(name = "strCountry")
    var strCountry: String? = null,
    @ColumnInfo(name = "idAssist")
    var idAssist: String? = null,
    @ColumnInfo(name = "strAssist")
    var strAssist: String? = null,
    @ColumnInfo(name = "intTime")
    var intTime: String? = null,
    @ColumnInfo(name = "idTeam")
    var idTeam: String? = null,
    @ColumnInfo(name = "strTeam")
    var strTeam: String? = null,
    @ColumnInfo(name = "strComment")
    var strComment: String? = null,
    @ColumnInfo(name = "dateEvent")
    var dateEvent: String? = null,
    @ColumnInfo(name = "strSeason")
    var strSeason: String? = null
)