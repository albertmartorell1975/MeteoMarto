package com.apps.albertmartorell.meteomarto.framework.db.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cities")
data class CityEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @Embedded
    val coordinates: CoordinatesEntity,
    @Embedded
    val weather: WeatherEntity,
    @Embedded
    val main: MainEntity,
    val visibility: Long = 0,
    @Embedded
    val wind: WindEntity,
    @Embedded
    val clouds: CloudsEntity,
    @Embedded
    val sys: SysEntity,
    val name: String = "",
    val dateServerUpdated: Long = 0
)