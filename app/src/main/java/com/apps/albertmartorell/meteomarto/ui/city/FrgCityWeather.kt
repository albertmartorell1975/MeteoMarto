package com.apps.albertmartorell.meteomarto.ui.city

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.apps.albertmartorell.meteomarto.R
import com.apps.albertmartorell.meteomarto.databinding.LytFrgCityWeatherBinding
import com.apps.albertmartorell.meteomarto.ui.PermissionRequester
import com.apps.albertmartorell.meteomarto.ui.loadIconsWeather
import com.apps.albertmartorell.meteomarto.ui.model.CityUIView
import kotlinx.android.synthetic.main.lyt_frg_city_weather.*

class FrgCityWeather : Fragment() {

    lateinit var binding: LytFrgCityWeatherBinding
    lateinit var root: ConstraintLayout
    lateinit var navController: NavController
    lateinit var viewModel: CityViewModel
    lateinit var coarsedPermissionRequest: PermissionRequester

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(CityViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.lyt_frg_city_weather, container, false)
        root = binding.root as ConstraintLayout
        binding.lifecycleOwner = viewLifecycleOwner
        //The third parameter of inflate specifies whether the inflated fragment should be added to the container.
        // The container is the parent view that will hold the fragment’s view hierarchy.
        // You should always set this to false when inflating a view for a fragment: The FragmentManager will take care of adding the fragment to the container.
        //return inflater.inflate(R.layout.lyt_frg_city_weather, container, false)
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        binding.lytFrgCityWeatherButton.setOnClickListener {

            val action =
                FrgCityWeatherDirections.actionFrgCityWeatherToFrgCityForecast(
                    3,
                    "2",
                    "Jaume"
                )
            navController.navigate(action)

        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        coarsedPermissionRequest =
            PermissionRequester(activity!!, Manifest.permission.ACCESS_COARSE_LOCATION)
        observeUI()

    }

    private fun observeUI() {

        viewModel.eventRequestLocationPermission.observe(
            this,
            Observer {

                it.getContentIfNotHandled()
                    ?.let {

                        makeViewsVisible(View.GONE)
                        progressBar.visibility = View.VISIBLE
                        coarsedPermissionRequest.request { permissionGranted: Boolean ->
                            viewModel.onCoarsePermissionRequested(
                                permissionGranted
                            )
                        }

                    }
            })

        viewModel.eventRequestedLocationPermissionFinished.observe(
            this,
            Observer {

                it.getContentIfNotHandled()?.let {

                    if (it.latitude == 0F || it.longitude == 0F) {

                        viewModel.getCityWeatherNotCoordinates()

                    } else {

                        viewModel.getCityWeatherFromService(it)

                    }

                }

            })

        viewModel.eventPermissionDenied.observe(this, Observer {

            it.getContentIfNotHandled()?.let {

                progressBar.visibility = View.GONE
                binding.lytFrgActPermissionDenied.visibility = View.VISIBLE

            }

        })

        viewModel.eventPermissionGranted.observe(
            this,
            Observer {

                it.getContentIfNotHandled()?.let {

                    viewModel.getCityWeather()

                }

            })

        viewModel.eventNotLocalData.observe(this, Observer {

            it.getContentIfNotHandled()?.let {

                progressBar.visibility = View.GONE
                binding.lytFrgCityWeatherNoCoordinates.visibility = View.VISIBLE

            }

        })

        viewModel.eventCityWeatherOffline.observe(this, Observer { cityView ->

            cityView.getContentIfNotHandled()?.let { response ->

                showData(response)
                binding.lytFrgCityWeatherNoCoordinates.visibility = View.VISIBLE

            }

        })

        viewModel.eventCityWeather.observe(this, Observer { cityView ->

            cityView.getContentIfNotHandled()?.let { response ->

                showData(response)

            }

        })

    }

    private fun showData(cityUIView: CityUIView) {

        binding.lytFrgCityWeatherDate.setText(cityUIView.date.toString())

        binding.lytFrgCityWeatherTempMin.setText(
            activity?.getString(
                R.string.min_temperature,
                cityUIView.temperatureMin.toString()
            )
        )

        binding.lytFrgCityWeatherTempMax.setText(
            activity?.getString(
                R.string.max_temperature,
                cityUIView.temperatureMax.toString()
            )
        )

        binding.lytFrgCityWeatherFeelsLike.setText(
            activity?.getString(
                R.string.feels_like,
                cityUIView.temperatureFeelsLike.toString()
            )
        )
        binding.lytFrgCityWeatherPressure.setText(
            activity?.getString(
                R.string.atmospheric_pressure,
                cityUIView.pressure.toString()
            )
        )

        binding.lytFrgCityWeatherDescription.setText(
            activity?.getString(
                R.string.current_weather,
                cityUIView.description.toString()
            )
        )

        binding.lytFrgCityWeatherIcon.loadIconsWeather(cityUIView.icon)
        binding.lytFrgCityWeatherName.setText(cityUIView.name)

        makeViewsVisible(View.VISIBLE)
        progressBar.visibility = View.GONE


    }

    private fun makeViewsVisible(_visibility: Int) {

        binding.lytFrgCityWeatherName.visibility = _visibility
        binding.lytFrgCityWeatherPressure.visibility = _visibility
        binding.lytFrgCityWeatherDate.visibility = _visibility
        binding.lytFrgCityWeatherDescription.visibility = _visibility
        binding.lytFrgCityWeatherIcon.visibility = _visibility
        binding.lytFrgCityWeatherTempMax.visibility = _visibility
        binding.lytFrgCityWeatherTempMin.visibility = _visibility
        binding.lytFrgCityWeatherFeelsLike.visibility = _visibility

    }

}