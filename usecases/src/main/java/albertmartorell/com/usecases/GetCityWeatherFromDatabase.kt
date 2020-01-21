package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.responses.City
import kotlinx.coroutines.flow.Flow

class GetCityWeatherFromDatabase(private val weatherRepository: WeatherRepository) {

    operator fun invoke(): Flow<City> {

        return weatherRepository.getCityWeatherFromDatabase()

    }

}