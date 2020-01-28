package albertmartorell.com.domain.cityweather

import com.google.gson.annotations.SerializedName

data class Clouds(@SerializedName("all") var coverage: Float? = 0F)