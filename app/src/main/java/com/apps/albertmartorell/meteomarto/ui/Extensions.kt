package com.apps.albertmartorell.meteomarto.ui

import android.content.Context
import android.location.Geocoder
import android.location.Location
import com.apps.albertmartorell.meteomarto.MeteoMartoApp

/*
 From a Location it returns a region. Else returns a default region
 */
fun Location?.toRegion(geoCoder: Geocoder, defaultRegion: String=""): String {

    val addresses = this?.let {

        geoCoder.getFromLocation(latitude, longitude, 1)

    }

    // If null, then location should be read from local database
    return addresses?.firstOrNull()?.countryCode ?: ""

}

val Context.app: MeteoMartoApp
    get() = applicationContext as MeteoMartoApp
// todo inflate layout, toast.....