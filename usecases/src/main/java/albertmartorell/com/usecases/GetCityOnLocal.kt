package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository

class GetCityOnLocal(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke() {

        weatherRepository.getCityWeatherOnLocal()

    }
}