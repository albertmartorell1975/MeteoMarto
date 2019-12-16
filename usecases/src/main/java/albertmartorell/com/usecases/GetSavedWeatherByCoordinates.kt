package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository

/**
 * This layer converts and passes user actions, also known as use cases, to inner layers of the application.
 *
 */

/**
 * It returns the weather saved on the device for an specific city saved on the local storage
 */
class GetSavedWeatherByCoordinates(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(_latitude: Float, _longitude: Float) {

        weatherRepository.getSavedWeatherByCoordinates(_latitude, _longitude)

    }

}