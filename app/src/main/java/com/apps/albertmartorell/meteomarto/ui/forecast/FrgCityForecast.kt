package com.apps.albertmartorell.meteomarto.ui.forecast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.apps.albertmartorell.meteomarto.R
import com.apps.albertmartorell.meteomarto.databinding.LytFrgCityForecastBinding

class FrgCityForecast : Fragment() {

    lateinit var binding: LytFrgCityForecastBinding
    lateinit var root: ConstraintLayout
    val args: FrgCityForecastArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.lyt_frg_city_forecast, container, false)
        root = binding.root as ConstraintLayout

        binding.lifecycleOwner = viewLifecycleOwner

        //binding.setViewModel(viewModel)
        //The third parameter of inflate specifies whether the inflated fragment should be added to the container.
        // The container is the parent view that will hold the fragment’s view hierarchy.
        // You should always set this to false when inflating a view for a fragment: The FragmentManager will take care of adding the fragment to the container.
        //return inflater.inflate(R.layout.lyt_frg_city_weather, container, false)
        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(context, "Toast 1: " + args.hola, Toast.LENGTH_SHORT).show()
        Toast.makeText(context, "Toast 2: " + args.hola2, Toast.LENGTH_SHORT).show()
        Toast.makeText(context, "Toast 3: " + args.hola3, Toast.LENGTH_SHORT).show()

    }

}