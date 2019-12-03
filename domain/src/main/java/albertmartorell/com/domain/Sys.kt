package albertmartorell.com.domain

data class Sys(
    var type: Int,
    var id: Long,
    var message: Float,
    var country: String,
    var sunrise: Long,
    var sunset: Long
)