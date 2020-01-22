package com.apps.albertmartorell.meteomarto.framework.db.common

import androidx.room.TypeConverter
import java.util.*


class DbTypeConverters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

}