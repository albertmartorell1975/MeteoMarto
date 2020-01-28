package albertmartorell.com.domain.cityweather

import com.google.gson.annotations.SerializedName

data class Coordinates(@SerializedName("lat") var latitude: Float?, @SerializedName("lon") var longitude: Float?)