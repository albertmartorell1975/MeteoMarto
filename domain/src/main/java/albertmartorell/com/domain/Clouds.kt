package albertmartorell.com.domain

import com.google.gson.annotations.SerializedName

data class Clouds(@SerializedName("all") var coverage: Float) {
}