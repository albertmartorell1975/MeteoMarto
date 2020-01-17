package com.apps.albertmartorell.meteomarto.framework.server

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.Result
import albertmartorell.com.domain.responses.City

class FakeRequestWeatherByName : WeatherRepository.WeatherServerSource {

    override suspend fun getCityWeatherByName(name: String): City {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override suspend fun getWeatherByCoordinates(
        latitude: Float,
        longitude: Float
    ): Result<City> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}