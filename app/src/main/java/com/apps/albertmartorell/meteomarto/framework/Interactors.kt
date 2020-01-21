package com.apps.albertmartorell.meteomarto.framework

import albertmartorell.com.usecases.FindCurrentRegion
import albertmartorell.com.usecases.GetCityWeatherFromDatabase
import albertmartorell.com.usecases.RequestWeatherByCoordinates
import albertmartorell.com.usecases.SaveCityWeather

/**
 * This data class contains all the use cases
 * I will use it to access use cases from ViewModels
 *
 */
data class Interactors(

    val findCurrentRegion: FindCurrentRegion,
    val getCityWeatherFromDatabase: GetCityWeatherFromDatabase,
    val requestWeatherByCoordinates: RequestWeatherByCoordinates,
    val saveCityWeather: SaveCityWeather

)