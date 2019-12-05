package albertmartorell.com.data.repositories

import albertmartorell.com.domain.responses.WeatherResponse
import retrofit2.Call


//We use the Repository pattern, which its main purpose is to abstract the concrete implementation of data access. To achieve this, I will add one interface and one class for each model
//Using the repository pattern is a good example of the Dependency Inversion Principle because an more abstract layer (data) does not depend on a more specific layer (framework),
//so the repository is an abstraction that do not depend on details

// The repository will user a couple of sources: one has access to the current weather (server) and the other to the saved weather (device). Both sources are interfaces which allow us the dependency inversion.
// The data layer does not know (and it does not need it) which is the implementation of these interfaces. The current and saved weathers must be manage by the specific frameworks (retrofit and room in this scope)
class WeatherRepository(
    private val serverSource: WeatherServerSource,
    private val deviceSource: WeatherDeviceSource
) {

    // now the repository can user both sources without need its implementation
    suspend fun requestWeatherByCoordinates(latitude: Float, longitude: Float) =
        serverSource.getWeather(latitude, longitude)

    suspend fun requestWeatherByName(name: String) = serverSource.getCityWeatherByName(name)

    suspend fun getSavedWeatherByCoordinates(latitude: Float, longitude: Float) =
        deviceSource.getDeviceCityWeatherByCoordinates(latitude, longitude)

    suspend fun getSavedWeatherByName(name: String) = deviceSource.getDeviceCityWeatherByName(name)

    /**
     * The interface that the framework layer must implement
     */
    interface WeatherServerSource {

        suspend fun getCityWeatherByName(name: String): Call<WeatherResponse>

        suspend fun getWeather(
            latitude: Float,
            longitude: Float
        ): Call<WeatherResponse>

    }

    interface WeatherDeviceSource {

        suspend fun getDeviceCityWeatherByName(name: String): WeatherResponse
        suspend fun getDeviceCityWeatherByCoordinates(
            latitude: Float,
            longitude: Float
        ): WeatherResponse

    }

}