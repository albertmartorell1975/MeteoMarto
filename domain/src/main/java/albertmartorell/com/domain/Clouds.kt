package albertmartorell.com.domain

import com.google.gson.annotations.SerializedName

data class Clouds(@SerializedName("all") val coverage: Float = 0F) {
}