package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.responses.City
import kotlinx.coroutines.flow.Flow

class RequestCityForecastByCoordinates(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(latitude: Float?, longitude: Float?): City {

        return weatherRepository.requestCityForecastByCoordinates(latitude, longitude)

    }

}