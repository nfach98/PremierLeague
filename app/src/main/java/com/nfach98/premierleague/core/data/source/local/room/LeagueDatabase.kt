package com.nfach98.premierleague.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nfach98.premierleague.core.data.source.local.entity.*

@Database(
    entities = [
        TableEntity::class,
        MatchEntity::class,
        ClubEntity::class,
        EquipmentEntity::class,
        PlayerEntity::class,
        TimelineEntity::class
     ],
    version = 1, exportSchema = false
)
abstract class LeagueDatabase : RoomDatabase() {

    abstract fun leagueDao(): LeagueDao
}