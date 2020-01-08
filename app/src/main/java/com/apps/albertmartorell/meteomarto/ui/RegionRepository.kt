package com.apps.albertmartorell.meteomarto.ui

import android.Manifest
import android.app.Activity
import android.location.Geocoder
import android.location.Location
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

/**
 * Entity that returns the current region (country)
 */
class RegionRepository(activity: Activity) {

    companion object {

        private val DEFAULT_REGION = "US"

    }

    // to get the current user location
    private var fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)
    // it checks if the user permission is granted
    private val coarsePermissionChecker = PermissionChecker(
        activity,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )
    // to get a direction from location to find out the country
    private var geoCoder = Geocoder(activity)

    suspend fun findLastRegion(): String = findLastLocation().toRegion(geoCoder, DEFAULT_REGION)

    private suspend fun findLastLocation(): Location? {

        val success = coarsePermissionChecker.request()
        return if (success) lastLocationSuspended() else null

    }

    /**
     * It collects the last localization, once finished it returns the localization as a result of the suspend function
     */
    private suspend fun lastLocationSuspended(): Location? =

        suspendCancellableCoroutine { continuation ->
            fusedLocationClient.lastLocation.addOnCompleteListener { continuation.resume(it.result) }

        }

}