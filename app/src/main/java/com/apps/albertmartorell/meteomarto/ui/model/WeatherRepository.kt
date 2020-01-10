package com.apps.albertmartorell.meteomarto.ui.model

import android.app.Application

class WeatherRepository(application: Application) {

    private val apiKey = "5e11044c499339f5ede8d58d85d134d3"
    private val regionRepository = RegionRepository(application)

    suspend fun getCityWeather(): String {

        return regionRepository.findLastRegion()

    }

}