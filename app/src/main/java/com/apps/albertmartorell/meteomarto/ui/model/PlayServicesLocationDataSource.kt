package com.apps.albertmartorell.meteomarto.ui.model

import android.app.Activity
import android.location.Location
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

/**
 * Entity that decouples RegionRepository from Google's LocationServices
 */

interface LocationDataSource {

    suspend fun findLastLocation(): Location?

}

class PlayServicesLocationDataSource(activity: Activity) : LocationDataSource {

    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity)

    /**
     * It collects the last localization, once finished it returns the localization as a result of the suspend function
     */
    override suspend fun findLastLocation(): Location? =

        suspendCancellableCoroutine { continuation ->
            fusedLocationClient.lastLocation.addOnCompleteListener {
                continuation.resume(it.result)
            }

        }

}