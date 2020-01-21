package albertmartorell.com.domain.responses

import albertmartorell.com.domain.*
import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("coord") var coordinates: Coordinates?,
    var weather: List<Weather>?,
    var main: Main?,
    var visibility: Long? = 0,
    var wind: Wind?,
    var clouds: Clouds?,
    var sys: Sys?,
    var name: String? = ""
)

//data class City(
//    var latitude: Float = 0F,
//    var longitude: Float = 0F,
//    var main: String = "",
//    var description: String = "",
//    var icon: String = "",
//    var temperature: Float = 0F,
//    var humidity: Float = 0F,
//    var pressure: Float = 0F,
//    var temperatureMin: Float = 0F,
//    var temperatureMax: Float = 0F,
//    val visibility: Long = 0,
//    var speed: Float = 0F,
//    var degrees: Float = 0F,
//    val coverage: Float = 0F,
//    var type: Int = 0,
//    var message: Float = 0F,
//    var country: String = "",
//    var sunrise: Long = 0,
//    var sunset: Long = 0,
//    val name: String = "",
//    val dateServerUpdated: Long = 0
//)