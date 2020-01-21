package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository

class DeleteAllCities(private val repository: WeatherRepository) {

    suspend operator fun invoke() {

        repository.deleteAllCities()

    }

}