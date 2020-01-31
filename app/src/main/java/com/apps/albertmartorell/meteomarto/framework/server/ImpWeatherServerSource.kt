package com.apps.albertmartorell.meteomarto.framework.server

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.cityforecast.ForecastDomain
import albertmartorell.com.domain.responses.City
import com.apps.albertmartorell.meteomarto.framework.db.common.convertForecastResponseToDomain

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
    ): List<ForecastDomain> {

        val forecastResponse = client.getForecast(latitude.toString(), longitude.toString())
        return convertForecastResponseToDomain(forecastResponse)

    }

}