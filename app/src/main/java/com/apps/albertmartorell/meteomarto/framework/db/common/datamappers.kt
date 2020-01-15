package com.apps.albertmartorell.meteomarto.framework.db.common

import albertmartorell.com.domain.*
import albertmartorell.com.domain.responses.City
import com.apps.albertmartorell.meteomarto.framework.db.entities.*

// From model domain to model database
fun City.convertToEntity(): CityEntity =

    CityEntity(
        0,
        Coordinates().convertToEntity(),
        Weather().convertToEntity(),
        Main().convertToEntity(),
        visibility,
        Wind().convertToEntity(),
        Clouds().convertToEntity(),
        Sys().convertToEntity(),
        name
    )

private fun Coordinates.convertToEntity(): CoordinatesEntity =

    CoordinatesEntity(
        latitude,
        longitude
    )

private fun Weather.convertToEntity(): WeatherEntity =

    WeatherEntity(
        main,
        description,
        icon
    )

private fun Main.convertToEntity(): MainEntity =

    MainEntity(
        temperature,
        humidity,
        pressure,
        temperatureMin,
        temperatureMax
    )

private fun Wind.convertToEntity(): WindEntity =

    WindEntity(
        speed,
        degrees
    )

private fun Clouds.convertToEntity(): CloudsEntity =

    CloudsEntity(
        coverage
    )

private fun Sys.convertToEntity(): SysEntity =

    SysEntity(
        type,
        message,
        country,
        sunrise,
        sunset
    )

// From model database to model domain
fun CityEntity.convertToResponse(): City =

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


// ****

/**
fun Movie.toRoomMovie(): DomainMovie =
DomainMovie(
id,
title,
overview,
releaseDate,
posterPath,
backdropPath,
originalLanguage,
originalTitle,
popularity,
voteAverage,
favorite
)

fun DomainMovie.toDomainMovie(): Movie = Movie(
id,
title,
overview,
releaseDate,
posterPath,
backdropPath,
originalLanguage,
originalTitle,
popularity,
voteAverage,
favorite
)

fun ServerMovie.toDomainMovie(): Movie =
Movie(
0,
title,
overview,
releaseDate,
posterPath,
backdropPath ?: posterPath,
originalLanguage,
originalTitle,
popularity,
voteAverage,
false
)

 **/