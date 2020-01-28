package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository

class DeleteAllForecast(private val repository: WeatherRepository) {

    suspend operator fun invoke() {

        return repository.deleteAllForecast()

    }

}