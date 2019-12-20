package albertmartorell.com.domain

import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp") val temperature: Float = 0.toFloat(),
    val humidity: Float = 0.toFloat(),
    val pressure: Float = 0.toFloat(),
    @SerializedName("temp_min") val temperatureMin: Float = 0.toFloat(),
    @SerializedName("temp_max") val temperatureMax: Float = 0.toFloat()
)