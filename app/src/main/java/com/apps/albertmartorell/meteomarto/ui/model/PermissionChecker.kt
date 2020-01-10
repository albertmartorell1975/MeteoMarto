package com.apps.albertmartorell.meteomarto.ui.model

import android.app.Application
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

/**
 *
 * Entity that allow us checking if a permission is granted
 */
class PermissionChecker(private val application: Application, private val permission: String) {

    fun check(): Boolean = ContextCompat.checkSelfPermission(
        application,
        permission
    ) == PackageManager.PERMISSION_GRANTED

}