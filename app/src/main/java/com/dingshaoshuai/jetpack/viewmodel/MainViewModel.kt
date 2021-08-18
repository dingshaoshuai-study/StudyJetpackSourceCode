package com.dingshaoshuai.jetpack.viewmodel

import androidx.lifecycle.ViewModel
import com.dingshaoshuai.jetpack.livedata.MLiveData
import kotlin.concurrent.thread

/**
 * @author: Xiao Bo
 * @date: 16/8/2021
 */
class MainViewModel : ViewModel() {
    private val _liveData = MLiveData<Int>()
    val liveData = _liveData
    private var thread: Thread? = null

    fun startThread() {
        thread = thread {
            while (thread?.isInterrupted != true) {
                liveData.postValue(
                    if (liveData.value == null) {
                        0
                    } else {
                        liveData.value!! + 1
                    }
                )
            }
        }
    }

    fun stopThread() {
        thread?.interrupt()
    }

    override fun onCleared() {
        super.onCleared()
        thread?.interrupt()
    }
}