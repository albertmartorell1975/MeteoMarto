package albertmartorell.com.data.repositories

import albertmartorell.com.domain.responses.City
import albertmartorell.com.domain.Result

// We use the Repository pattern, which its main purpose is to abstract the concrete implementation of data access. To achieve this, I will add one interface and one class for each model
// Using the repository pattern is a good example of the Dependency Inversion Principle because an more abstract layer (data) does not depend on a more specific layer (framework),
// so the repository is an abstraction that do not depend on details

// The repository will user a couple of sources: one has access to the current weather (server) and the other to the saved weather (device). Both sources are interfaces which allow us the dependency inversion.
// The data layer does not know (and it does not need it) which is the implementation of these interfaces. The current and saved weathers must be manage by the specific frameworks (retrofit and room in this scope)
// Now the repository can user both sources without need its implementation
class WeatherRepository(
    private val serverSource: WeatherServerSource,
    private val deviceSource: WeatherDeviceSource
) {

    //    suspend fun getCityWeatherOnLocal(latitude: Float, longitude: Float): City {
//
//        if (deviceSource.isEmpty()) {
//
//            val cityWeather = serverSource.getWeatherByCoordinates(latitude, longitude)
//            deviceSource.saveCityWeather(cityWeather)
//
//        }
//
//        return deviceSource.getCityWeatherByCoordinates(latitude, longitude)
//
//    }

    suspend fun getCityWeatherFromDatabase() {

        if (!deviceSource.isEmpty()) {

            deviceSource.getCity()

        }

    }

    suspend fun requestWeatherByCoordinates(latitude: Float, longitude: Float): Result<City> {

        return serverSource.getWeatherByCoordinates(latitude, longitude)

    }

    suspend fun requestWeatherByName(name: String) = serverSource.getCityWeatherByName(name)

    suspend fun getSavedWeatherByCoordinates(latitude: Float, longitude: Float) =
        deviceSource.getCityWeatherByCoordinates(latitude, longitude)

    suspend fun getSavedWeatherByName(name: String) = deviceSource.getCityWeatherByName(name)

    /**
     * The interface that the framework layer must implement
     *
     */
    interface WeatherServerSource {

        suspend fun getCityWeatherByName(name: String): City

        suspend fun getWeatherByCoordinates(
            latitude: Float,
            longitude: Float
        ): Result<City>

    }

    interface WeatherDeviceSource {

        suspend fun getCity()
        suspend fun isEmpty(): Boolean
        suspend fun saveCityWeather(cityWeather: City)
        suspend fun getCityWeatherByName(name: String): City
        suspend fun getCityWeatherByCoordinates(
            latitude: Float,
            longitude: Float
        ): City

    }

}