package albertmartorell.com.domain.responses

import albertmartorell.com.domain.*
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("coord") var coordinates: Coordinates?,
    var weather: List<Weather>?,
    var main: Main?,
    var visibility: Long = 0,
    var wind: Wind?,
    var clouds: Clouds?,
    var sys: Sys?,
    //var id: Long = 0,
    var name: String = ""
)