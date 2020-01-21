package com.apps.albertmartorell.meteomarto.framework.db

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.responses.City
import android.content.Context
import com.apps.albertmartorell.meteomarto.framework.db.common.convertToEntity
import com.apps.albertmartorell.meteomarto.framework.db.common.convertToResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

/**
 * It implements one dependency offered by the data layer, in this case the WeatherDeviceSource
 *
 */
class ImpWeatherDeviceSource(context: Context) : WeatherRepository.WeatherDeviceSource {

    // Use database to get an instance of WeatherDao and store it in local field
    private val dao = MeteoMartoDatabase.getInstance(context).weatherDao()

    override suspend fun isEmpty(): Boolean {

        if (dao.getAll().count() > 0)
            return true
        else
            return false

    }

    override suspend fun saveCityWeather(cityWeather: City) {

        dao.insertWeatherCity(cityWeather.convertToEntity())

    }

    override fun getCity(): Flow<City> {

        return dao.getCity().map { it.convertToResponse() }.distinctUntilChanged()

    }

}