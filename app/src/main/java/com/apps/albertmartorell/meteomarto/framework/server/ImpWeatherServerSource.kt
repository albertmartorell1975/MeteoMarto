package com.apps.albertmartorell.meteomarto.framework.server

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.responses.City
import albertmartorell.com.domain.responses.Forecast

/**
 * It implements one dependency offered by the data layer, in this case the WeatherServerSource
 *
 */
class ImpWeatherServerSource : WeatherRepository.WeatherServerSource {

    var client = RetrofitBuilder.cityWeatherByCoordinates

    override suspend fun getWeatherByCoordinates(latitude: Float?, longitude: Float?): City {

        return client.getWeather(latitude.toString(), longitude.toString())

    }

    override suspend fun requestCityForecastByCoordinates(
        latitude: Float?,
        longitude: Float?
    ): Forecast {

        return client.getForecast(latitude.toString(), longitude.toString())

    }

}