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
    val requestWeatherByCoordinates: RequestWeatherByCoordinates
//    val getSavedWeatherByCoordinates: GetSavedWeatherByCoordinates,
//    val getSavedWeatherByName: GetSavedWeatherByName,
//    val requestWeatherByName: FakeRequestWeatherByName
)