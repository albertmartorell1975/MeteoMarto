package albertmartorell.com.domain.responses

import albertmartorell.com.domain.cityforecast.ListForecast

data class Forecast(
    val list: List<ListForecast>?

)