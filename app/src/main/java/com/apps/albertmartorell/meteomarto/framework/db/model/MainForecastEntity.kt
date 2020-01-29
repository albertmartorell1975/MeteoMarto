package com.apps.albertmartorell.meteomarto.framework.db.model

data class MainForecastEntity(
    var temperatureMin: Float = 0F,
    var temperatureMax: Float = 0F,
    var temperatureFeelLike: Float = 0F
)