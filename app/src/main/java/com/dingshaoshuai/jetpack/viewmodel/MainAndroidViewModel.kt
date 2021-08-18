package com.dingshaoshuai.jetpack.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.dingshaoshuai.jetpack.livedata.MLiveData
import kotlin.concurrent.thread

/**
 * @author: Xiao Bo
 * @date: 17/8/2021
 */
class MainAndroidViewModel(application: Application) : AndroidViewModel(application) {

    private val _liveData = MLiveData<Int>()
    val liveData = _liveData
    private var thread: Thread? = null

    val name = ObservableField<String>("小明")
    val age = ObservableField<String>("18")

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