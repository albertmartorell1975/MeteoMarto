package com.apps.albertmartorell.meteomarto.ui.city

import albertmartorell.com.domain.Coordinates
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.albertmartorell.meteomarto.framework.Interactors
import com.apps.albertmartorell.meteomarto.framework.db.common.convertToCityUIView
import com.apps.albertmartorell.meteomarto.ui.Scope
import com.apps.albertmartorell.meteomarto.ui.common.Event
import com.apps.albertmartorell.meteomarto.ui.model.CityUIView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CityViewModel(private val interactors: Interactors) : ViewModel(), Scope {

    override lateinit var job: Job

//    sealed class UiModel {
//
//        object Loading : UiModel()
//        object RequestLocationPermission : UiModel()
//
//        object PermissionGranted : UiModel() // location permission is granted
//
//        object PermissionDenied : UiModel() // location permission is denied
//
//        class Success(val cityEntity: String) : UiModel()
//         //As it has state, it must be a class
//        class Finished(val cityEntity: String) : UiModel()
//
//        object cityWeatherCollected : UiModel() // the city weather has been already collected
//        object NotInternet : UiModel() // there is not Internet connection
//
//    }

    private val _eventStartRequestForecast = MutableLiveData<Event<Unit>>()
    val eventStartRequestForecast: LiveData<Event<Unit>>
        get() {

            if (_eventStartRequestForecast.value == null) {

                startRequestForecast()
            }

            return _eventStartRequestForecast

        }


    private fun startRequestForecast() {

        _eventStartRequestForecast.value = Event(Unit)

    }

    private val _eventRequestLocationPermission = MutableLiveData<Event<Unit>>()

    val eventRequestLocationPermission: LiveData<Event<Unit>>
        get() {

            // the first time somebody subscribes to the LiveData
            if (_eventRequestLocationPermission.value == null) {

                refresh()

            }

            return _eventRequestLocationPermission

        }

    private val _eventNotLocalData = MutableLiveData<Event<Unit>>()
    val eventNotLocalData: LiveData<Event<Unit>> = _eventNotLocalData

    private val _eventPermissionDenied = MutableLiveData<Event<Unit>>()
    val eventPermissionDenied: LiveData<Event<Unit>> = _eventPermissionDenied

    private val _eventPerMissionGranted = MutableLiveData<Event<Unit>>()
    val eventPermissionGranted: LiveData<Event<Unit>> = _eventPerMissionGranted

    private val _eventRequestedLocationPermissionFinished = MutableLiveData<Event<Coordinates>>()
    val eventRequestedLocationPermissionFinished = _eventRequestedLocationPermissionFinished

    //private val _eventCityWeather = MutableLiveData<Event<City>>()
//    val eventCityWeather: LiveData<City> =
//        interactors.getCityWeatherFromDatabase.invoke().collect{
//            eventCityWeather.value = it
//        }

    private val _eventCityWeather = MutableLiveData<Event<CityUIView>>()
    val eventCityWeather = _eventCityWeather

    private val _eventCityWeatherOffline = MutableLiveData<Event<CityUIView>>()
    val eventCityWeatherOffline = _eventCityWeatherOffline

    init {

        initScope()

    }

    /**
     * I wonder when to call this method: a good moment is wait when somebody is subscribed to the LiveData
     * for the first time. As alternative it could be called in the init constructor
     */
    private fun refresh() {

        _eventRequestLocationPermission.value = Event(Unit)

    }

    fun onCoarsePermissionRequested(_success: Boolean) {

        launch {

            if (_success)
                _eventPerMissionGranted.value = Event(Unit)
            else
                _eventPermissionDenied.value = Event(Unit)

        }

    }

    fun getCityWeather() {

        launch {

            _eventRequestedLocationPermissionFinished.value =
                Event(interactors.findCurrentRegion.invoke())

        }

    }

    /**
     * The app has not been able to collect the location. Then It tries to get the last city saved on the database
     */
    fun getCityWeatherNotCoordinates() {

        launch {

            try {

                withContext(Dispatchers.IO) {
                    interactors.getCityWeatherFromDatabase.invoke().collect {

                        withContext(Dispatchers.Main) {
                            _eventCityWeatherOffline.value = Event(it.convertToCityUIView())
                        }

                    }

                }

            } catch (ex: java.lang.Exception) {

                // No city saved on the local database
                withContext(Dispatchers.Main) { _eventNotLocalData.value = Event(Unit) }

            }

        }

    }

    fun getCityWeatherFromService(coordinates: Coordinates) {

        launch {

            withContext(Dispatchers.IO) {

                try {

                    val response = interactors.requestWeatherByCoordinates.invoke(
                        coordinates.latitude,
                        coordinates.longitude
                    )

                    interactors.deleteAllCities.invoke()
                    interactors.saveCityWeather.invoke(response)
                    interactors.getCityWeatherFromDatabase.invoke().collect {

                        withContext(Dispatchers.Main) {
                            _eventCityWeather.value = Event(it.convertToCityUIView())
                        }

                    }

                } catch (ex: Exception) {

                    // error
                    interactors.getCityWeatherFromDatabase.invoke().collect {

                        withContext(Dispatchers.Main) {
                            _eventCityWeatherOffline.value = Event(it.convertToCityUIView())
                        }

                    }

                }

            }

        }

    }

    fun requestCityForecastByCoordinates(latitude: Float?, longitude: Float?) {

        launch {

            withContext(Dispatchers.IO) {

                try {

                    val response = interactors.requestCityForecastByCoordinates.invoke(
                        latitude, longitude
                    )

                    val s = ""
                    /**
                    interactors.deleteAllCities.invoke()
                    interactors.saveCityWeather.invoke(response)
                    interactors.getCityWeatherFromDatabase.invoke().collect {

                    withContext(Dispatchers.Main) {
                    _eventCityWeather.value = Event(it.convertToCityUIView())
                    }

                    }**/

                } catch (ex: Exception) {

                    val s = ""
                    // error
                    /**
                    interactors.getCityWeatherFromDatabase.invoke().collect {

                    withContext(Dispatchers.Main) {
                    _eventCityWeatherOffline.value = Event(it.convertToCityUIView())
                    }

                    }
                     **/

                }

            }

        }

    }

    override fun onCleared() {

        cancelScope()

    }

    /**
     * As CityViewModel has arguments, we need to create it with a factory, else Android will create a ViewModel with empty constructor, and CityViewModel needs arguments
     */
    @Suppress("UNCHECKED_CAST")
    class CityViewModelFactory(private val interactors: Interactors) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T =

            CityViewModel(interactors) as T

    }

}