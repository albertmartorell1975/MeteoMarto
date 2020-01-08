package com.apps.albertmartorell.meteomarto.ui.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.apps.albertmartorell.meteomarto.R
import com.apps.albertmartorell.meteomarto.databinding.LytFrgCityWeatherBinding

class FrgCityWeather : Fragment() {

    lateinit var binding: LytFrgCityWeatherBinding
    lateinit var root: ConstraintLayout
    lateinit var navController: NavController


//    // Provides a method fro creating new instances of the fragment (factory method)
//    companion object {
//
//        fun newInstance(): FrgCityWeather {
//
//            return FrgCityWeather()
//
//        }
//
//    }


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

}