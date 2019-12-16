package com.apps.albertmartorell.meteomarto.framework.server

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.responses.WeatherResponse
import retrofit2.Call

class FakeRequestWeatherByName: WeatherRepository.WeatherServerSource {

    override suspend fun getCityWeatherByName(name: String): Call<WeatherResponse> {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override suspend fun getWeatherByCoordinates(
        latitude: Float,
        longitude: Float
    ): Call<WeatherResponse> {


        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}