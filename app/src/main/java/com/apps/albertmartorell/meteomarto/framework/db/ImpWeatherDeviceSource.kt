package com.apps.albertmartorell.meteomarto.framework.db

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.*
import albertmartorell.com.domain.responses.City
import android.content.Context
import com.apps.albertmartorell.meteomarto.framework.db.common.convertToResponse
import com.apps.albertmartorell.meteomarto.framework.db.entities.*

/**
 * It implements one dependency offered by the data layer, in this case the WeatherDeviceSource
 *
 */
class ImpWeatherDeviceSource(context: Context) : WeatherRepository.WeatherDeviceSource {

    // Use database to get an instance of WeatherDao an d store it in local field
    private val dao = MeteoMartoDatabase.getInstance(context).weatherDao()

    override suspend fun getCityWeatherByName(name: String): City {

        return dao.getCityWeatherByName(name).convertToResponse()

    }

    override suspend fun getCityWeatherByCoordinates(
        latitude: Float,
        longitude: Float

    ): City {

        return dao.getCityWeatherByCoordinates(latitude, longitude).convertToResponse()

    }

    override suspend fun isEmpty(): Boolean {

        if (dao.getAll().count() > 0)
            return true
        else
            return false

    }

    override suspend fun saveCityWeather(cityWeather: City) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getCity() {

        dao.getCity()

    }

}