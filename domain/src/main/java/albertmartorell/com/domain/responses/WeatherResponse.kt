package albertmartorell.com.domain.responses

import albertmartorell.com.domain.*
import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("coord") var coordinates: Coordinates, var weather: List<Weather>,
    var main: Main,
    var visibitliy: Long = 0,
    var wind: Wind,
    var clouds: Clouds,
    var sys: Sys,
    var id: Long = 0,
    var name: String = ""
) {

    //{"coord":{"lon":-0.13,"lat":51.51},
    // "weather":[{"id":300,"main":"Drizzle", "description":"light intensity drizzle","icon":"09d"}],
    // "base":"stations",
    // "main":{"temp":280.32, "pressure":1012,"humidity":81,"temp_min":279.15,"temp_max":281.15},
    // "visibility":10000,
    // "wind":{"speed":4.1,"deg":80},
    // "clouds":{"all":90},
    // "dt":1485789600,
    // "sys":{"type":1,"id":5091,"message":0.0103,"country":"GB","sunrise":1485762037,"sunset":1485794875},
    // "id":2643743,
    // "name":"London",
    // "cod":200}

}