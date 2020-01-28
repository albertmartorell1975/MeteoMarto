package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository

class RequestCityForecastByCoordinates(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(latitude: Float?, longitude: Float?): albertmartorell.com.domain.responses.Forecast {

        return weatherRepository.requestCityForecastByCoordinates(latitude, longitude)

    }

}