package albertmartorell.com.domain

import com.google.gson.annotations.SerializedName

data class Wind(
    var speed: Float = 0.toFloat(),
    @SerializedName("deg") var degrees: Float = 0.toFloat()
)