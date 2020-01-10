package com.apps.albertmartorell.meteomarto.ui.city

import android.Manifest
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.apps.albertmartorell.meteomarto.R
import com.apps.albertmartorell.meteomarto.databinding.LytActLandingBinding
import com.apps.albertmartorell.meteomarto.ui.PermissionRequester
import com.apps.albertmartorell.meteomarto.ui.city.CityViewModel.CityViewModelFactory
import com.apps.albertmartorell.meteomarto.ui.city.CityViewModel.UiModel
import com.apps.albertmartorell.meteomarto.ui.model.WeatherRepository
import kotlinx.android.synthetic.main.lyt_act_landing.*

class Landing : AppCompatActivity() {

    private lateinit var viewModel: CityViewModel
    private lateinit var binding: LytActLandingBinding
    private val coarsedPermissionRequest =
        PermissionRequester(this, Manifest.permission.ACCESS_COARSE_LOCATION)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // the this param does that each time we access the view model providers checks if this view model already exists: if not it is created else it is got again
        viewModel = ViewModelProviders.of(
            this,
            CityViewModelFactory(WeatherRepository(application))
        )[CityViewModel::class.java]

        binding = DataBindingUtil.setContentView(this, R.layout.lyt_act_landing)
        binding.lifecycleOwner = this
        viewModel.model.observe(this, Observer { UiModel -> updateUI(viewModel.model.value) })
        //viewModel.model.observe(this, Observer(::updateUI))

    }

    private fun updateUI(model: UiModel?) {

        when (model) {

            is UiModel.RequestLocationPermission -> {

                progressBar.visibility = View.VISIBLE
                // this is a lambda function: val lambdaName : Type = { argumentList -> codeBody }
                // The only part of a lambda which is not optional is the codeBody. So the below lambda only have the codeBody:
                //coarsedPermissionRequest.request { viewModel.onCoarsePermissionRequested()}
                viewModel.onCoarsePermissionRequested(coarsedPermissionRequest.request())

            }

            is UiModel.PermissionDenied -> {

                progressBar.visibility = View.GONE
                binding.lytFrgActPermissionDenied.visibility = View.VISIBLE

            }

            is UiModel.Loading ->
                progressBar.visibility = View.VISIBLE

            is UiModel.Content -> {

                progressBar.visibility = View.GONE

//                val square = { number: Int ->
//                    val result = number * number
//                    result.toString()
//                }
//                val nine = square(3)
                //Toast.makeText(this, square(11), Toast.LENGTH_SHORT).show()
                Toast.makeText(this, model.cityEntity, Toast.LENGTH_SHORT).show()

            }

            is UiModel.NotInternet -> {

                progressBar.visibility = View.GONE
                Toast.makeText(this, "Not Internet", Toast.LENGTH_SHORT).show()

            }

        }

    }

}