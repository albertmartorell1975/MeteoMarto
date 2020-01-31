package albertmartorell.com.domain.cityforecast

data class ForecastDomain(
    val time: String? = "",
    val temperatureMin: Int? = 0,
    val temperatureMax: Int? = 0,
    val temperatureFeelsLike: Int? = 0,
    val description: String? = "",
    val icon: String? = ""
)