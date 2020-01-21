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

                        progressBar.visibility = View.VISIBLE
                        // this is a lambda function: val lambdaName : Type = { argumentList -> codeBody }
                        // The only part of a lambda which is not optional is the codeBody. So the below lambda only have the codeBody:
                        //coarsedPermissionRequest.request { viewModel.onCoarsePermissionRequested(it) }
                        viewModel.onCoarsePermissionRequested(coarsedPermissionRequest.request())

                    }
            })

        viewModel.eventRequestedLocationPermissionFinished.observe(
            this,
            Observer {

                it.getContentIfNotHandled()?.let {

                    if (it.latitude == 0F || it.longitude == 0F) {

                        viewModel.getCityWeatherFromDatabase()

                    } else {

                        viewModel.getCityWeatherFromService(it)

                    }

                }

            })

        viewModel.eventPermissionGranted.observe(
            this,
            Observer {

                it.getContentIfNotHandled()?.let {

                    viewModel.getCityWeather()

                }

            })

        viewModel.eventPermissionDenied.observe(this, Observer {

            it.getContentIfNotHandled()?.let {

                progressBar.visibility = View.GONE
                binding.lytFrgActPermissionDenied.visibility = View.VISIBLE

            }

        })

        viewModel.eventFinished.observe(this, Observer {

            it.getContentIfNotHandled()?.let {

                progressBar.visibility = View.GONE
                binding.lytFrgActPermissionDenied.visibility = View.VISIBLE
                //lyt_frg_city_weather.visibility = View.VISIBLE

            }

        })

        viewModel.eventCityWeather.observe(this, Observer {

            it.getContentIfNotHandled()?.let {

                progressBar.visibility = View.GONE
                binding.lytFrgCityWeatherDate.setText(it.coordinates?.longitude.toString())

            }

        }

        )

    }

}