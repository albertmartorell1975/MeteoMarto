package com.apps.albertmartorell.meteomarto.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val main: String = "",
    val description: String = "",
    val icon: String = "",
    val dateServerUpdated: Long = 0
)