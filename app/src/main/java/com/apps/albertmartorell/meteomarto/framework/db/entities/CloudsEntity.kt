package com.apps.albertmartorell.meteomarto.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clouds")
data class CloudsEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val coverage: Float = 0F
)