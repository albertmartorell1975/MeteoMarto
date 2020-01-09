package com.apps.albertmartorell.meteomarto.ui

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

/**
 * Each entity that has a lifecycle will need the below functions. So I have created this interface to avoid boilerplate code
 */
interface Scope : CoroutineScope {

    //In kotlin can have interfaces with code but no with state
    var job: Job
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    fun initScope() {

        //A job created using SupervisorJob won’t fail when one of its children fails
        job = SupervisorJob()

    }

    fun cancelScope() {

        job.cancel()

    }

}