package com.apps.albertmartorell.meteomarto.framework.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "forecasts")
data class ForecastEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val temperatureMin: Float? = 0F,
    val temperatureMax: Float?,
    val temperatureFeelsLike: Float? = 0F,
    val weather: String? = "",
    val weatherIcon: String? = ""
)