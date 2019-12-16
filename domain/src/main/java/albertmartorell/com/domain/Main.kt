package albertmartorell.com.domain

import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp") var temperature: Float = 0.toFloat(),
    var humidity: Float = 0.toFloat(),
    var pressure: Float = 0.toFloat(),
    @SerializedName("temp_min") var temperatureMin: Float = 0.toFloat(),
    @SerializedName("temp_max") var temperatureMax: Float = 0.toFloat()
)