package albertmartorell.com.data

import albertmartorell.com.data.server.interfaces.ICityWeatherByCoordinates
import albertmartorell.com.data.server.interfaces.ICitytWeatherByName
import retrofit2.Retrofit


class CityWeatherRepo(
    private val cityWeatherByNam2 : ICitytWeatherByName,
    private val cityWeatherByCoordinates: ICityWeatherByCoordinates
) {

fun test(){


}
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