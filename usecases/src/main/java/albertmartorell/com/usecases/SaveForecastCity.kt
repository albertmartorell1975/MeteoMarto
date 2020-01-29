package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.cityforecast.ForecastDomain

class SaveForecastCity(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(forecastDomain: List<ForecastDomain>) {

        weatherRepository.saveForecastCity(forecastDomain)

    }

}