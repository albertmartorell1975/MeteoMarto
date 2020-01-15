package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository

class GetCityWeatherFromDatabase(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke() {

        weatherRepository.getCityWeatherFromDatabase()

    }
}