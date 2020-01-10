package com.apps.albertmartorell.meteomarto.ui.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.apps.albertmartorell.meteomarto.ui.Scope
import com.apps.albertmartorell.meteomarto.ui.model.WeatherRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CityViewModel(private val weatherRepository: WeatherRepository) : ViewModel(), Scope {

    override lateinit var job: Job

    sealed class UiModel {

        object Loading : UiModel()
        // As it has state, it must be a class
        class Content(val cityEntity: String) : UiModel()

        object NotInternet : UiModel()

        object RequestLocationPermission : UiModel()

        object PermissionDenied : UiModel()
        //todo it left others ui scopes....
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {

            // the first time somebody subscribes to the LiveData
            if (_model.value == null) {

                refresh()

            }

            return _model

        }

    init {

        initScope()

    }

    /**
     * I wonder when to call this method: a good moment is wait when somebody is subscribed to the LiveData for the first time. As alternative it could be called in the init constructor
     */
    private fun refresh() {

        _model.value = UiModel.RequestLocationPermission

    }

    fun onCoarsePermissionRequested(success: Boolean) {

        launch {

            //_model.value = UiModel.Loading
            if (success) _model.value =
                UiModel.Content(weatherRepository.getCityWeather()) else _model.value =
                UiModel.PermissionDenied

        }

    }

    override fun onCleared() {

        cancelScope()

    }

    /**
     * As CityViewModel has arguments, we need to create it with a factory, else Android will create a ViewModel with empty constructor, and CityViewModel needs arguments
     */
    @Suppress("UNCHECKED_CAST")
    class CityViewModelFactory(private val weatherRepository: WeatherRepository) :
        ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T =

            CityViewModel(weatherRepository) as T

    }

}