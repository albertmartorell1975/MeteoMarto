package com.apps.albertmartorell.meteomarto.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
data class CityEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    var latitude: Float? = 0F,
    var longitude: Float? = 0F,
    var main: String? = "",
    var description: String? = "",
    var icon: String? = "",
    var temperature: Float? = 0F,
    var humidity: Float? = 0F,
    var pressure: Float? = 0F,
    var temperatureMin: Float? = 0F,
    var temperatureMax: Float? = 0F,
    val visibility: Long? = 0,
    var speed: Float? = 0F,
    var degrees: Float? = 0F,
    val coverage: Float? = 0F,
    var type: Int? = 0,
    var message: Float? = 0F,
    var country: String? = "",
    var sunrise: Long? = 0,
    var sunset: Long? = 0,
    val name: String? = "",
    val dateServerUpdated: Long? = 0
)