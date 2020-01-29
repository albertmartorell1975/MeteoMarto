package albertmartorell.com.domain.responses

import albertmartorell.com.domain.cityforecast.ListForecast

data class ForecastResponse(
    val list: List<ListForecast>

)