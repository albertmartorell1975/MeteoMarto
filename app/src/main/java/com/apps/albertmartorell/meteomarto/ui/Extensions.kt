package com.apps.albertmartorell.meteomarto.ui

import android.location.Geocoder
import android.location.Location

/*
 From a Location it returns a region. Else returns a default region
 */
fun Location?.toRegion(geoCoder: Geocoder, defaultRegion: String): String {

    val addresses = this?.let {

        geoCoder.getFromLocation(latitude, longitude, 1)

    }

    // If null, then location should be read from local database
    return addresses?.firstOrNull()?.countryCode ?: ""

}

// todo inflate layout, toast.....