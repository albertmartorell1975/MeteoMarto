package com.apps.albertmartorell.meteomarto.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sys")
data class SysEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val type: Int = 0,
    val message: String = "",
    val country: String = "",
    val sunrise: Long = 0,
    val sunset: Long = 0
)