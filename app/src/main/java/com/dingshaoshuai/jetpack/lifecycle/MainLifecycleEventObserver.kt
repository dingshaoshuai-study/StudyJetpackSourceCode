package com.dingshaoshuai.jetpack.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.dingshaoshuai.jetpack.MLog

/**
 * @author: Xiao Bo
 * @date: 16/8/2021
 */
class MainLifecycleEventObserver : LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        val state = when (event) {
            Lifecycle.Event.ON_CREATE -> "ON_CREATE"
            Lifecycle.Event.ON_START -> "ON_START"
            Lifecycle.Event.ON_RESUME -> "ON_RESUME"
            Lifecycle.Event.ON_PAUSE -> "ON_PAUSE"
            Lifecycle.Event.ON_STOP -> "ON_STOP"
            Lifecycle.Event.ON_DESTROY -> "ON_DESTROY"
            else -> throw NoSuchMethodException()
        }
        MLog.i("state: $state")
    }
}