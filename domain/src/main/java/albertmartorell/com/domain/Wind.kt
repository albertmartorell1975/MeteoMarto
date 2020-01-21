package albertmartorell.com.domain

import com.google.gson.annotations.SerializedName

data class Wind(
    val speed: Float? = 0.toFloat(),
    @SerializedName("deg")
    val degrees: Float? = 0.toFloat()
)