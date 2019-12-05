package albertmartorell.com.usecases

import albertmartorell.com.data.repositories.WeatherRepository

/**
 * It returns the weather saved on the device for an specific city
 */
class GetSavedWeather(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(){

        
    }
}