package albertmartorell.com.data

import albertmartorell.com.data.server.interfaces.ICityWeatherByCoordinates
import albertmartorell.com.data.server.interfaces.ICitytWeatherByName
import albertmartorell.com.domain.Forecast

class WeatherRepo {

    class CityWeatherRepoImplementer(
        private val cityWeatherByName: ICitytWeatherByName,
        private val cityWeatherByCoordinates: ICityWeatherByCoordinates
    ) :
        IWeatherRepo {

        override suspend fun getCityWeatherByName(name: String): Forecast.Weather =
            cityWeatherByName.getWeather(name)


        override suspend fun getCityWeatherByCoordinates(
            latitude: Float,
            longitude: Float
        ): Forecast.Coord =

            cityWeatherByCoordinates.getWeather(latitude.toString(), longitude.toString())


    }

    interface IWeatherRepo {

        suspend fun getCityWeatherByName(name: String): Forecast.Weather

        suspend fun getCityWeatherByCoordinates(latitude: Float, longitude: Float): Forecast.Coord

    }

}
