package com.apps.albertmartorell.meteomarto.ui

import android.app.Activity
import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.single.BasePermissionListener

/**
 * This entity ask for an specific permission
 *
 * Dexter uses callbacks to return the result if a permission is granted or denied, so in teory we do not have a synchronous way to do it.
 * But there is an alternative:
 *
 * We need to call suspend function that creates this modification (from async to sync). The idea is that the value the callback returns, becomes the value
 * that the suspend function returns. We can do it through the SuspendCoroutine, which returns a Continuation object that is the result of the callback,
 * which is used as a value to return
 */
class PermissionRequester(private val activity: Activity, private val permission: String) {

    fun request(continuation: (Boolean) -> Unit) {

        Dexter
            .withActivity(activity)
            .withPermission(permission)
            .withListener(object : BasePermissionListener() {

                // callback
                override fun onPermissionGranted(response: PermissionGrantedResponse?) {

                    // the value that we want to return
                    continuation(true)

                }

                // callback
                override fun onPermissionDenied(response: PermissionDeniedResponse?) {

                    // the value that we want to return
                    continuation(false)

                }

//                override fun onPermissionRationaleShouldBeShown(
//                    permission: PermissionRequest,
//                    token: PermissionToken?
//                ) {
//                    // This method will be called when the user rejects a permission request
//                    // You must display a dialog box that explains to the user why the application needs this permission
//                    token?.continuePermissionRequest()
//                   continue(false)
//
//                }

            }).check()

    }

}