package com.apps.albertmartorell.meteomarto.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "sys")
data class SysEntity(
    //@PrimaryKey(autoGenerate = true) var id: Long = 0,
    var type: Int = 0,
    var message: Float = 0F,
    var country: String = "",
    var sunrise: Long = 0,
    var sunset: Long = 0
    //var dateServerUpdated: Long = 0
)