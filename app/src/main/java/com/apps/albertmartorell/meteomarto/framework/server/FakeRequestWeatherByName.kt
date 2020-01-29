package com.apps.albertmartorell.meteomarto.framework.server

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.cityforecast.ForecastDomain
import albertmartorell.com.domain.responses.City

class FakeRequestWeatherByName : WeatherRepository.WeatherServerSource {

    override suspend fun getWeatherByCoordinates(latitude: Float?, longitude: Float?): City {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun requestCityForecastByCoordinates(
        latitude: Float?,
        longitude: Float?
    ): List<ForecastDomain> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}