package com.apps.albertmartorell.meteomarto.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
data class CityEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val coordinates: CoordinatesEntity,
    val weather: WeatherEntity,
    val main: MainEntity,
    val visibility: Long = 0,
    val wind: WindEntity,
    val clouds: CloudsEntity,
    val sys: SysEntity,
    val name: String = ""
)