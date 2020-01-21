package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository
import albertmartorell.com.domain.Result
import albertmartorell.com.domain.responses.City

class SaveCityWeather(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(city: City) {

        weatherRepository.saveCityWeather(city)

    }

}