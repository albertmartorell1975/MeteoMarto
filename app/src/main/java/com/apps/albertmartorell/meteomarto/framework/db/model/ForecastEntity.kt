package com.apps.albertmartorell.meteomarto.framework.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "forecasts")
data class ForecastEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val time: String? = "",
    val temperatureMin: Int? = 0,
    val temperatureMax: Int? = 0,
    val temperatureFeelsLike: Int? = 0,
    val weather: String? = "",
    val weatherIcon: String? = ""
)