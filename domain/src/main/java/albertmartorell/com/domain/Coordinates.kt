package albertmartorell.com.domain

import com.google.gson.annotations.SerializedName

data class Coordinates(
    @SerializedName("long")
    val longitude: Float = 0.toFloat(), @SerializedName("lat")
    val latitude: Float = 0.toFloat()
)