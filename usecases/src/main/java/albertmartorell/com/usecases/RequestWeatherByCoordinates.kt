package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository

/**
 * Request city weather by its coordinates from a server service
 */
class RequestWeatherByCoordinates(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(_latitude: Float, _longitude: Float) {

        weatherRepository.requestWeatherByCoordinates(_latitude, _longitude)

    }

}