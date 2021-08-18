package com.dingshaoshuai.jetpack.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.dingshaoshuai.jetpack.MLog

/**
 * @author: Xiao Bo
 * @date: 16/8/2021
 *
 */
class MainLifecycleObserver : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    private fun onAny() {
        // 每次有新的生命周期方法调用，都会调用 onAny
//        MLog.i("onAny")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate() {
        MLog.i("onCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onStart() {
        MLog.i("onStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun onResume() {
        MLog.i("onResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun onPause() {
        MLog.i("onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private fun onStop() {
        MLog.i("onStop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        MLog.i("onDestroy")
    }
}