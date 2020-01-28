package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.Result
import albertmartorell.com.domain.responses.City
import albertmartorell.com.domain.responses.Forecast

class SaveForecastCity(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(forecast: Forecast) {

        weatherRepository.saveForecastCity(forecast)

    }

}