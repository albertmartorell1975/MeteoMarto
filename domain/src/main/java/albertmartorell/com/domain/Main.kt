package albertmartorell.com.domain

import com.google.gson.annotations.SerializedName

data class Main(@SerializedName("temp") var temperature: Float, var humidity:Float, var pressure:Float,
                @SerializedName("temp_min") var temperatureMin:Float, @SerializedName("temp_max") var temperatureMax:Float) {

//    @SerializedName("temp")
//    var temp: Float = 0.toFloat()
//    @SerializedName("humidity")
//    var humidity: Float = 0.toFloat()
//    @SerializedName("pressure")
//    var pressure: Float = 0.toFloat()
//    @SerializedName("temp_min")
//    var temp_min: Float = 0.toFloat()
//    @SerializedName("temp_max")
//    var temp_max: Float = 0.toFloat()

}