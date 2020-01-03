package com.apps.albertmartorell.meteomarto.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "main")
data class MainEntity(
    //@PrimaryKey(autoGenerate = true) var id: Long = 0,
    var temperature: Float = 0F,
    var humidity: Float = 0F,
    var pressure: Float = 0F,
    var temperatureMin: Float = 0F,
    var temperatureMax: Float = 0F
    //var dateServerUpdated: Long = 0
)