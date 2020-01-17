package com.apps.albertmartorell.meteomarto.framework.server

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.Result
import albertmartorell.com.domain.ResultHandler
import albertmartorell.com.domain.responses.City

/**
 * It implements one dependency offered by the data layer, in this case the WeatherServerSource
 *
 */
class ImpWeatherServerSource : WeatherRepository.WeatherServerSource {

    var client = RetrofitBuilder.cityWeatherByCoordinates

    override suspend fun getCityWeatherByName(name: String): City {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override suspend fun getWeatherByCoordinates(latitude: Float, longitude: Float): Result<City> {

        val resultHandler = ResultHandler()

        val result: Result<City> = resultHandler.safeApiCall(
            { client.getWeather(latitude.toString(), longitude.toString()) }, "Error occurred"
        )

        return result

    }

}