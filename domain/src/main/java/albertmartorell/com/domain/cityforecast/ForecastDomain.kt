package albertmartorell.com.domain.cityforecast

data class ForecastDomain(
    val time: String? = "",
    val temperatureMin: Float? = 0F,
    val temperatureMax: Float? = 0F,
    val temperatureFeelsLike: Float? = 0F,
    val description: String? = "",
    val icon: String? = ""
)