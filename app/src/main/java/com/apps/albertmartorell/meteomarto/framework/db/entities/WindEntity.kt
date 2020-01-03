package com.apps.albertmartorell.meteomarto.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "wind")
data class WindEntity(
    //@PrimaryKey(autoGenerate = true) var id: Long = 0,
    var speed: Float = 0F,
    var degrees: Float = 0F
    //var dateServerUpdated: Long = 0
)