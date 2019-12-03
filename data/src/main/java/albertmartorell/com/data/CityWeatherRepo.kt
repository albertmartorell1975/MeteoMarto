package albertmartorell.com.data

import albertmartorell.com.data.server.interfaces.ICityWeatherByCoordinates
import albertmartorell.com.data.server.interfaces.ICitytWeatherByName


class CityWeatherRepo(
    private val cityWeatherByName : ICitytWeatherByName,
    private val cityWeatherByCoordinates: ICityWeatherByCoordinates
) {

//    fun getCityWeatherByName(name: String) {
//
//        cityWeatherByName.getWeather(name)
//
//    }
//
//    fun getCityWeatherByCoordinates(latitude: Float, longitude: Float) {
//
//        cityWeatherByCoordinates.getWeather(latitude.toString(), longitude.toString())
//
//    }

}