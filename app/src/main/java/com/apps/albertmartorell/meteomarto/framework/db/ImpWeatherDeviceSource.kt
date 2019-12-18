package com.apps.albertmartorell.meteomarto.framework.db

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.*
import albertmartorell.com.domain.responses.WeatherResponse
import android.content.Context
import com.apps.albertmartorell.meteomarto.framework.db.entities.*

/**
 * It implements one dependency offered by the data layer, in this case the WeatherDeviceSource
 *
 */
class ImpWeatherDeviceSource(context: Context) : WeatherRepository.WeatherDeviceSource {

    private val dao = MeteoMartoDatabase.getInstance(context).weatherDao()

    override suspend fun getCityWeatherByName(name: String): WeatherResponse {

        return dao.getCityWeatherByName(name)

    }

    override suspend fun getCityWeatherByCoordinates(
        latitude: Float,
        longitude: Float

    ): WeatherResponse {

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    private fun WeatherResponse.convertToEntity() {

        CityEntity(
            0,
            Coordinates().convertToEntity(),
            Weather().convertToEntity(),
            Main().convertToEntity(),
            visibility,
            Wind().convertToEntity(),
            Clouds().convertToEntity(),
            Sys().converToEntity(),
            name
        )

    }

    private fun Coordinates.convertToEntity() =
        CoordinatesEntity(0, latitude, longitude)

    private fun Weather.convertToEntity() =
        WeatherEntity(0, main, description, icon)

    private fun Main.convertToEntity() =
        MainEntity(0, temperature, humidity, pressure, temperatureMin, temperatureMax)

    private fun Wind.convertToEntity() =
        WindEntity(0, speed, degrees)

    private fun Clouds.convertToEntity() =
        CloudsEntity(0, coverage)

    private fun Sys.converToEntity() =
        SysEntity(0, type, message, country, sunrise, sunset)

}