package com.apps.albertmartorell.meteomarto.framework.db

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.*
import albertmartorell.com.domain.responses.City
import android.content.Context
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

        return dao.getCityWeatherByCoordinates(latitude, longitude ).convertToResponse()

    }

    override suspend fun isEmpty(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun saveCityWeather(cityWeather: City) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getCity(): City {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // Converters

    private fun CityEntity.convertToResponse(): City =

        City(
            CoordinatesEntity().convertToResponse(),
            WeatherEntity().convertToResponse(),
            MainEntity().convertToResponse(),
            visibility,
            WindEntity().convertToResponse(),
            CloudsEntity().convertToResponse(),
            SysEntity().convertToResponse(),
            name
        )

    private fun CoordinatesEntity.convertToResponse() =

        Coordinates(
            latitude,
            longitude
        )

    private fun WeatherEntity.convertToResponse(): List<Weather> {

        val weather = Weather(main, description, icon)
        val weatherList: List<Weather> = listOf(weather)
        return weatherList

    }

    private fun MainEntity.convertToResponse() =

        Main(
            temperature,
            humidity,
            pressure,
            temperatureMin,
            temperatureMax
        )

    private fun WindEntity.convertToResponse() =

        Wind(
            speed,
            degrees
        )

    private fun CloudsEntity.convertToResponse() =
        Clouds(coverage)

    private fun SysEntity.convertToResponse() =

        Sys(
            type,
            message,
            country,
            sunrise,
            sunset
        )

//    private fun WeatherResponse.convertToEntity(): CityEntity =
//
//        CityEntity(
//            0,
//            Coordinates().convertToEntity(),
//            Weather().convertToEntity(),
//            Main().convertToEntity(),
//            visibility,
//            Wind().convertToEntity(),
//            Clouds().convertToEntity(),
//            Sys().converToEntity(),
//            name
//        )
//
//    private fun Coordinates.convertToEntity(): CoordinatesEntity =
//
//        CoordinatesEntity(
//            0,
//            latitude,
//            longitude
//        )
//
//    private fun Weather.convertToEntity(): WeatherEntity =
//
//        WeatherEntity(
//            0,
//            main,
//            description,
//            icon
//        )
//
//    private fun Main.convertToEntity(): MainEntity =
//
//        MainEntity(
//            0,
//            temperature,
//            humidity,
//            pressure,
//            temperatureMin,
//            temperatureMax
//        )
//
//    private fun Wind.convertToEntity(): WindEntity =
//
//        WindEntity(
//            0,
//            speed,
//            degrees
//        )
//
//    private fun Clouds.convertToEntity(): CloudsEntity =
//
//        CloudsEntity(
//            0,
//            coverage
//        )
//
//    private fun Sys.converToEntity(): SysEntity =
//
//        SysEntity(
//            0,
//            type,
//            message,
//            country,
//            sunrise,
//            sunset
//        )

}