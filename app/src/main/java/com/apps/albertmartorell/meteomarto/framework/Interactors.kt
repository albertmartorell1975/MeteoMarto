package com.apps.albertmartorell.meteomarto.framework

import albertmartorell.com.usecases.*

/**
 * This data class contains all the use cases
 * I will use it to access use cases from ViewModels
 *
 */
data class Interactors(

    val findCurrentRegion: FindCurrentRegion,
    val getCityWeatherFromDatabase: GetCityWeatherFromDatabase,
    val requestWeatherByCoordinates: RequestWeatherByCoordinates,
    val saveCityWeather: SaveCityWeather,
    val deleteAllCities: DeleteAllCities,
    val requestCityForecastByCoordinates: RequestCityForecastByCoordinates,
    val deleteAllForecast: DeleteAllForecast

)