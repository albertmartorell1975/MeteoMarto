package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.cityforecast.ForecastDomain

class RequestCityForecastByCoordinates(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(latitude: Float?, longitude: Float?): List<ForecastDomain> {

        return weatherRepository.requestCityForecastByCoordinates(latitude, longitude)

    }

}