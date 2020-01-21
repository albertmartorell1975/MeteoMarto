package com.apps.albertmartorell.meteomarto.framework.db.common

import albertmartorell.com.domain.*
import albertmartorell.com.domain.responses.City
import com.apps.albertmartorell.meteomarto.framework.db.entities.CityEntity
import com.apps.albertmartorell.meteomarto.framework.db.entities.WeatherEntity

// From model domain to model database
fun City.convertToEntity(): CityEntity =

    CityEntity(
        0,
        coordinates?.latitude,
        coordinates?.longitude,
        weather?.get(0)?.main,
        weather?.get(0)?.description,
        weather?.get(0)?.icon,
        main?.temperature,
        main?.humidity,
        main?.pressure,
        main?.temperatureMin,
        main?.temperatureMax,
        visibility,
        wind?.speed,
        wind?.degrees,
        clouds?.coverage,
        sys?.type,
        sys?.message,
        sys?.country,
        sys?.sunrise,
        sys?.sunset,
        name

    )

//private fun Coordinates.convertToEntity(): CoordinatesEntity =
//
//    CoordinatesEntity(
//        latitude,
//        longitude
//    )
//
//private fun Weather.convertToEntity(): WeatherEntity =
//
//    WeatherEntity(
//        main,
//        description,
//        icon
//    )
//
//private fun Main.convertToEntity(): MainEntity =
//
//    MainEntity(
//        temperature,
//        humidity,
//        pressure,
//        temperatureMin,
//        temperatureMax
//    )

//private fun Wind.convertToEntity(): WindEntity =
//
//    WindEntity(
//        speed,
//        degrees
//    )
//
//private fun Clouds.convertToEntity(): CloudsEntity =
//
//    CloudsEntity(
//        coverage
//    )
//
//private fun Sys.convertToEntity(): SysEntity =
//
//    SysEntity(
//        type,
//        message,
//        country,
//        sunrise,
//        sunset
//    )

// From model database to model domain
fun CityEntity.convertToResponse(): City =

    City(
        Coordinates(latitude, longitude),
        WeatherEntity().convertToResponse(main, description, icon),
        Main(
            temperature,
            humidity,
            pressure,
            temperatureMin,
            temperatureMax
        ),
        visibility,
        Wind(speed, degrees),
        Clouds(coverage),
        Sys(
            type,
            message,
            country,
            sunrise,
            sunset
        ),
        name
    )

//// From model domain to model database
//fun City.convertToEntity(): CityEntity =
//
//    CityEntity(
//        0,
//        Coordinates().latitude,
//        CoordinatesEntity().longitude,
//        Weather().convertToEntity(),
//        Main().convertToEntity(),
//        visibility,
//        Wind().convertToEntity(),
//        Clouds().convertToEntity(),
//        Sys().convertToEntity(),
//        name
//    )
//
//private fun Coordinates.convertToEntity(): CoordinatesEntity =
//
//    CoordinatesEntity(
//        latitude,
//        longitude
//    )
//
//private fun Weather.convertToEntity(): WeatherEntity =
//
//    WeatherEntity(
//        main,
//        description,
//        icon
//    )
//
//private fun Main.convertToEntity(): MainEntity =
//
//    MainEntity(
//        temperature,
//        humidity,
//        pressure,
//        temperatureMin,
//        temperatureMax
//    )
//
//private fun Wind.convertToEntity(): WindEntity =
//
//    WindEntity(
//        speed,
//        degrees
//    )
//
//private fun Clouds.convertToEntity(): CloudsEntity =
//
//    CloudsEntity(
//        coverage
//    )
//
//private fun Sys.convertToEntity(): SysEntity =
//
//    SysEntity(
//        type,
//        message,
//        country,
//        sunrise,
//        sunset
//    )
//
//// From model database to model domain
//fun CityEntity.convertToResponse(): City =
//
//    City(
//        CoordinatesEntity().convertToResponse(),
//        WeatherEntity().convertToResponse(),
//        MainEntity().convertToResponse(),
//        visibility,
//        WindEntity().convertToResponse(),
//        CloudsEntity().convertToResponse(),
//        SysEntity().convertToResponse(),
//        name
//    )
//
//private fun CoordinatesEntity.convertToResponse() =
//
//    Coordinates(
//        latitude,
//        longitude
//    )
//
private fun WeatherEntity.convertToResponse(
    main: String?,
    description: String?,
    icon: String?
): List<Weather> {

    val weather = Weather(main, description, icon)
    val weatherList: List<Weather> = listOf(weather)

    return weatherList

}
//
//private fun MainEntity.convertToResponse() =
//
//    Main(
//        temperature,
//        humidity,
//        pressure,
//        temperatureMin,
//        temperatureMax
//    )
//
//private fun WindEntity.convertToResponse() =
//
//    Wind(
//        speed,
//        degrees
//    )
//
//private fun CloudsEntity.convertToResponse() =
//    Clouds(coverage)
//
//private fun SysEntity.convertToResponse() =
//
//    Sys(
//        type,
//        message,
//        country,
//        sunrise,
//        sunset
//    )
//
