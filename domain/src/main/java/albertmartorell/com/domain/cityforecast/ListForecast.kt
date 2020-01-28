package albertmartorell.com.domain.cityforecast

import com.google.gson.annotations.SerializedName

data class ListForecast(
    @SerializedName("dt") val time: Long? = 0,
    val main: MainForecast?,
    val weather: List<WeatherForecast>?

)