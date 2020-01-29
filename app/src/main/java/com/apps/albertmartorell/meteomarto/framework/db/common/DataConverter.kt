package com.apps.albertmartorell.meteomarto.framework.db.common

import albertmartorell.com.domain.cityforecast.ForecastDomain
import albertmartorell.com.domain.cityforecast.ListForecast
import albertmartorell.com.domain.cityweather.*
import albertmartorell.com.domain.responses.City
import albertmartorell.com.domain.responses.ForecastResponse
import com.apps.albertmartorell.meteomarto.framework.db.model.CityEntity
import com.apps.albertmartorell.meteomarto.framework.db.model.ForecastEntity
import com.apps.albertmartorell.meteomarto.framework.db.model.WeatherEntity
import com.apps.albertmartorell.meteomarto.ui.model.CityUIView

const val FROM_KELVIN_TO_CELSIUS = 273

fun convertFromKelvinToCelsius(temperature: Float?): Float? {

    temperature?.let {

        return temperature - FROM_KELVIN_TO_CELSIUS
    }

    return 0F

}

fun convertForecastDomainToEntity(forecastDomain: List<ForecastDomain>): List<ForecastEntity> {

    return forecastDomain.map { it.saveDomainAsEntity() }

}

fun convertForecastEntityToDomain(forecastEntity: List<ForecastEntity>): List<ForecastDomain> {

    return forecastEntity.map { it.convertToDomain() }

}

fun convertForecastResponseToDomain(forecastResponse: ForecastResponse): List<ForecastDomain> {

    return forecastResponse.list?.map { it.saveListForecastAsDomain() }

}

fun ForecastDomain.saveDomainAsEntity(): ForecastEntity =

    ForecastEntity(
        0,
        convertFromKelvinToCelsius(temperatureMin),
        convertFromKelvinToCelsius(temperatureMax),
        convertFromKelvinToCelsius(temperatureFeelsLike),
        description, icon
    )

//From domain model to database model
fun ListForecast.saveListForecastAsEntity(): ForecastEntity =

    ForecastEntity(
        0,
        convertFromKelvinToCelsius(main?.temperatureMin),
        convertFromKelvinToCelsius(main?.temperatureMax),
        convertFromKelvinToCelsius(main?.temperatureFeelsLike),
        weather?.get(0)?.description, weather?.get(0)?.icon
    )

//From domain model to database model
fun ListForecast.saveListForecastAsDomain(): ForecastDomain =

    ForecastDomain(
        convertFromKelvinToCelsius(main?.temperatureMin),
        convertFromKelvinToCelsius(main?.temperatureMax),
        convertFromKelvinToCelsius(main?.temperatureFeelsLike),
        "", weather?.get(0)?.description, weather?.get(0)?.icon
    )

// From domain model to database model
fun City.saveCityAsEntity(): CityEntity =

    CityEntity(
        0,
        coordinates?.latitude,
        coordinates?.longitude,
        weather?.get(0)?.main,
        weather?.get(0)?.description,
        weather?.get(0)?.icon,
        convertFromKelvinToCelsius(main?.temperature),
        main?.humidity,
        main?.pressure,
        convertFromKelvinToCelsius(main?.temperatureMin),
        convertFromKelvinToCelsius(main?.temperatureMax),
        convertFromKelvinToCelsius(main?.temperatureFeelsLike),
        visibility,
        wind?.speed,
        wind?.degrees,
        clouds?.coverage,
        sys?.type,
        sys?.message,
        sys?.country,
        sys?.sunrise,
        sys?.sunset,
        name,
        DbTypeConverters().dateToTimestamp(System.currentTimeMillis())

    )

// From model domain to model view
fun City.convertToCityUIView(): CityUIView =

    CityUIView(
        coordinates?.latitude,
        coordinates?.longitude,
        weather?.get(0)?.main,
        weather?.get(0)?.description,
        weather?.get(0)?.icon,
        convertFromKelvinToCelsius(main?.temperature),
        main?.humidity,
        main?.pressure,
        main?.temperatureMin,
        main?.temperatureMax,
        main?.temperatureFeelsLike,
        visibility,
        wind?.speed,
        wind?.degrees,
        clouds?.coverage,
        sys?.type,
        sys?.message,
        sys?.country,
        sys?.sunrise,
        sys?.sunset,
        name,
        DbTypeConverters().dateToTimestamp(System.currentTimeMillis())

    )

// From database model to domain model
fun ForecastEntity.convertToDomain(): ForecastDomain =

    ForecastDomain(temperatureMin, temperatureMax, temperatureFeelsLike, "", weather, weatherIcon)

fun List<ForecastEntity>.convertToDomain2(): ForecastDomain =

    return this.map { it.convertToDomain() }


    //ForecastDomain(temperatureMin, temperatureMax, temperatureFeelsLike, "", weather, weatherIcon)


// From database model to domain model
fun CityEntity.convertToResponse(): City =

    City(
        Coordinates(latitude, longitude),
        WeatherEntity().convertToResponse(main, description, icon),
        Main(
            temperature,
            humidity,
            pressure,
            temperatureMin,
            temperatureMax,
            temperatureFeelsLike
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

private fun WeatherEntity.convertToResponse(
    main: String?,
    description: String?,
    icon: String?
): List<Weather> {

    val weather = Weather(main, description, icon)
    val weatherList: List<Weather> = listOf(weather)

    return weatherList

}

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