package com.apps.albertmartorell.meteomarto.ui

import android.content.Context
import android.location.Geocoder
import android.location.Location
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import com.apps.albertmartorell.meteomarto.MeteoMartoApp
import com.apps.albertmartorell.meteomarto.framework.server.RetrofitBuilder
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

/*
 From a Location it returns a region. Else returns a default region
 */
fun Location?.toRegion(geoCoder: Geocoder, defaultRegion: String = ""): String {

    val addresses = this?.let {

        geoCoder.getFromLocation(latitude, longitude, 1)

    }

    // If null, then location should be read from local database
    return addresses?.firstOrNull()?.countryCode ?: ""

}

val Context.app: MeteoMartoApp
    get() = applicationContext as MeteoMartoApp


@BindingAdapter("getWeatherIcon")
fun ImageView.loadIconsWeather(url: String?) {

    url?.let {
        Glide.with(this)
            .load(RetrofitBuilder.iconsPrefixWeatherUrl + url + RetrofitBuilder.iconsSuffixWeatherUrl)
            .into(this)
    }

}

fun View.snackBar(_message: String, _length: Int = Snackbar.LENGTH_LONG) {

    val snack = Snackbar.make(this, _message, _length)
    snack.show()

}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {

    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

}