package com.apps.albertmartorell.meteomarto.framework.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wind")
data class WindEntity(
    @PrimaryKey(autoGenerate = true)
    val Long: Int = 0,
    val speed: Float = 0F,
    val degrees: Float = 0F
)