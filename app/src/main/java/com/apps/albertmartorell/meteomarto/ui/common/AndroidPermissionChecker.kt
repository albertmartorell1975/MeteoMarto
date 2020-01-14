package com.apps.albertmartorell.meteomarto.ui.common

import albertmartorell.com.data.repositories.PermissionChecker
import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.app.Application
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

/**
 *
 * Entity that allow us checking if a permission is granted
 */

class AndroidPermissionChecker(private val application: Application) : PermissionChecker {

    override suspend fun check(permission: PermissionChecker.Permission): Boolean =
        ContextCompat.checkSelfPermission(
            application,
            permission.toAndroidId()
        ) == PackageManager.PERMISSION_GRANTED
}

private fun PermissionChecker.Permission.toAndroidId() = when (this) {

    PermissionChecker.Permission.COARSE_LOCATION -> ACCESS_COARSE_LOCATION

}