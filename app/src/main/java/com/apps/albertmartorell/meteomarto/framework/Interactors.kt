package com.apps.albertmartorell.meteomarto.framework

import albertmartorell.com.usecases.GetSavedWeatherByCoordinates
import albertmartorell.com.usecases.GetSavedWeatherByName
import albertmartorell.com.usecases.RequestWeatherByCoordinates
import com.apps.albertmartorell.meteomarto.framework.server.FakeRequestWeatherByName

/**
 * This data class contains all the use cases
 * I will use it to access use cases from ViewModels
 *
 */
data class Interactors(

    val getSavedWeatherByCompiler: GetSavedWeatherByCoordinates,
    val getSavedWeatherByName: GetSavedWeatherByName,
    val requestWeatherByCoordinates: RequestWeatherByCoordinates,
    val requestWeatherByName: FakeRequestWeatherByName
)