package albertmartorell.com.domain

/**
 * Sealed classes are used for representing restricted class hierarchies, when a value can have one of the types from a limited set,
 * but cannot have any other type
 */
sealed class Forecast {

    data class Weather(val id: Int, val main: String, val description: String, val icon: String)
    data class Coord(val lon: Float, val lat: Float)

}