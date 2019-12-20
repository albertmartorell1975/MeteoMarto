package albertmartorell.com.domain.responses

import albertmartorell.com.domain.*
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("coord") val coordinates: Coordinates?,
    val weather: List<Weather>?,
    val main: Main?,
    val visibility: Long = 0,
    val wind: Wind?,
    val clouds: Clouds?,
    val sys: Sys?,
    val name: String = ""
)