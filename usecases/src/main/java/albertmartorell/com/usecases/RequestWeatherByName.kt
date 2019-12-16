package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository

/**
 * Request city weather by its name from a server service
 */
class RequestWeatherByName(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(_city: String) {

        weatherRepository.requestWeatherByName(_city)

    }

}