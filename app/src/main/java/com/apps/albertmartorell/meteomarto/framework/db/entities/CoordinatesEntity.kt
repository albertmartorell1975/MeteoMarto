package com.apps.albertmartorell.meteomarto.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "coordinates")
data class CoordinatesEntity(
    //@PrimaryKey(autoGenerate = true) val id: Long = 0,
    var longitude: Float = 0F,
    var latitude: Float = 0F
    //val dateServerUpdated: Long = 0
)