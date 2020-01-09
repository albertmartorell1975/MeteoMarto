package com.apps.albertmartorell.meteomarto.ui.model

import android.app.Activity

class WeatherRepository(activity: Activity) {

    private val apiKey = "5e11044c499339f5ede8d58d85d134d3"
    private val regionRepository = RegionRepository(activity)

    suspend fun getCityWeather(): String {

        return regionRepository.findLastRegion()

    }
}