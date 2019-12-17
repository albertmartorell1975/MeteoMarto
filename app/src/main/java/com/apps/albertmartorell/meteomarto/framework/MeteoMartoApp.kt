package com.apps.albertmartorell.meteomarto.framework

import albertmartorell.com.data.repositories.WeatherRepository
import android.app.Application
import androidx.room.Room
import com.apps.albertmartorell.meteomarto.framework.db.ImpWeatherDeviceSource
import com.apps.albertmartorell.meteomarto.framework.db.MeteoMartoDatabase
import com.apps.albertmartorell.meteomarto.framework.server.ImpWeatherServerSource

class MeteoMartoApp : Application() {

    // It is marked with "late-init" to crash if it is not initialized before use (and that's exactly what we want)
    lateinit var meteoMartoDatabase: MeteoMartoDatabase
    val weatherRepository =
        WeatherRepository(ImpWeatherServerSource(), ImpWeatherDeviceSource(this))

    override fun onCreate() {

        super.onCreate()
        meteoMartoDatabase =
            Room.databaseBuilder(this, MeteoMartoDatabase::class.java, "MeteoMartoDatabase").build()

    }

}