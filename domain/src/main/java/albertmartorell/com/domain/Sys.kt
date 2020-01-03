package albertmartorell.com.domain

data class Sys(
    var type: Int = 0,
    var message: Float = 0.toFloat(),
    var country: String = "",
    var sunrise: Long = 0,
    var sunset: Long = 0
)