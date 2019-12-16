package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository

/**
 * It returns the specific weather by city name saved on the local storage
 */
class GetSavedWeatherByName(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(_city: String) {

        weatherRepository.getSavedWeatherByName(_city)

    }

}