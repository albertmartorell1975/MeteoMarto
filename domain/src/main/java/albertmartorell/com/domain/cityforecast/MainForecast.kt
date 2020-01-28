package albertmartorell.com.domain.cityforecast

import com.google.gson.annotations.SerializedName

data class MainForecast(
    @SerializedName("temp_min") val temperatureMin: Float? = 0F,
    @SerializedName("temp_max") val temperatureMax: Float? = 0F,
    @SerializedName("feels_like") val temperatureFeelsLike: Float? = 0F
)