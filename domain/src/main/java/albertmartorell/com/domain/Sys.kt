package albertmartorell.com.domain

data class Sys(
    val type: Int = 0,
    val message: Float = 0.toFloat(),
    val country: String = "",
    val sunrise: Long = 0,
    val sunset: Long = 0
)