package com.apps.albertmartorell.meteomarto.framework.server

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.responses.WeatherResponse
import retrofit2.Call

/**
 * It implements one dependency offered by the data layer, in this case the WeatherServerSource
 *
 */
class ImpWeatherServerSource : WeatherRepository.WeatherServerSource {

    override suspend fun getCityWeatherByName(name: String): WeatherResponse {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override suspend fun getWeatherByCoordinates(
        latitude: Float,
        longitude: Float
    ): WeatherResponse {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

}