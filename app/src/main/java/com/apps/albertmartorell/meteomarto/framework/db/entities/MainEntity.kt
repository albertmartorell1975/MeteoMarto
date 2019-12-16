package com.apps.albertmartorell.meteomarto.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "main")
data class MainEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, val temperature: Float = 0F,
    val humidity: Float = 0F,
    val pressure: Float = 0F,
    val temperatureMin: Float = 0F,
    val temperatureMax: Float = 0F
)