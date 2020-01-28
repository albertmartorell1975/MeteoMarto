package albertmartorell.com.domain.responses

import albertmartorell.com.domain.cityforecast.CityForecast
import albertmartorell.com.domain.cityforecast.ListForecast

data class Forecast(
    val city: CityForecast?,
    val list: List<ListForecast>?

)