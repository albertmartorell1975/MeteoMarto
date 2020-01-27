package com.apps.albertmartorell.meteomarto.framework.server

import albertmartorell.com.data.repositories.WeatherRepository
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

    override suspend fun getWeatherByCoordinates(latitude: Float?, longitude: Float?): City {

        val result = client.getWeather(latitude.toString(), longitude.toString())
        return result

    }

    override suspend fun requestCityForecastByCoordinates(
        latitude: Float?,
        longitude: Float?
    ): City {

        return client.getForecast(latitude.toString(), longitude.toString())

    }
}