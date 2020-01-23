package com.apps.albertmartorell.meteomarto.framework.db.common

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

const val DATE_FORMAT = "DD/MM/YYYY HH:mm"

class DbTypeConverters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {

        return value?.let { Date(it) }

    }

    @TypeConverter
    fun dateToTimestamp(value: Long?): String? {

        val date = value?.let { Date(it) }
        return SimpleDateFormat(DATE_FORMAT, Locale.US).format(date)

    }

}