package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.cityforecast.ForecastDomain
import kotlinx.coroutines.flow.Flow

class GetForecastCityFromDatabase(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(): Flow<List<ForecastDomain>> {

        return weatherRepository.getForecastCityFromDatabase()

    }

}