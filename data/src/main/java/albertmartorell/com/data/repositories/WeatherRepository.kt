package albertmartorell.com.data.repositories

import albertmartorell.com.domain.responses.WeatherResponse
import retrofit2.Call


// We use the Repository pattern, which its main purpose is to abstract the concrete implementation of data access. To achieve this, I will add one interface and one class for each model
// Using the repository pattern is a good example of the Dependency Inversion Principle because an more abstract layer (data) does not depend on a more specific layer (framework),
// so the repository is an abstraction that do not depend on details

// The repository will user a couple of sources: one has access to the current weather (server) and the other to the saved weather (device). Both sources are interfaces which allow us the dependency inversion.
// The data layer does not know (and it does not need it) which is the implementation of these interfaces. The current and saved weathers must be manage by the specific frameworks (retrofit and room in this scope)
// Now the repository can user both sources without need its implementation
class WeatherRepository(
    val serverSource: WeatherServerSource,
    val deviceSource: WeatherDeviceSource
) {

    //Note that you mark all the methods with the suspend modifier. This allows you to use coroutine-powered mechanisms in Room or Retrofit, for simpler threading.

    suspend fun requestWeatherByCoordinates(latitude: Float, longitude: Float) =
        serverSource.getWeatherByCoordinates(latitude, longitude)

    suspend fun requestWeatherByName(name: String) = serverSource.getCityWeatherByName(name)

    suspend fun getSavedWeatherByCoordinates(latitude: Float, longitude: Float) =
        deviceSource.getCityWeatherByCoordinates(latitude, longitude)

    suspend fun getSavedWeatherByName(name: String) = deviceSource.getCityWeatherByName(name)

    /**
     * The interface that the framework layer must implement
     *
     * Nota: PODRIEM SEPARAR CADA MÈTODE EN UNA INTERFACE A PART (en aquest cas n'hi haurien 4)
     */
    interface WeatherServerSource {

        suspend fun getCityWeatherByName(name: String): Call<WeatherResponse>

        suspend fun getWeatherByCoordinates(
            latitude: Float,
            longitude: Float
        ): Call<WeatherResponse>

    }

    interface WeatherDeviceSource {

        suspend fun getCityWeatherByName(name: String): WeatherResponse
        suspend fun getCityWeatherByCoordinates(
            latitude: Float,
            longitude: Float
        ): WeatherResponse

    }

}