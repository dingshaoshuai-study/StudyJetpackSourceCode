package com.dingshaoshuai.jetpack.livedata

import androidx.lifecycle.MutableLiveData
import com.dingshaoshuai.jetpack.MLog

/**
 * @author: Xiao Bo
 * @date: 16/8/2021
 */
class MLiveData<T> : MutableLiveData<T>() {

    override fun postValue(value: T) {
        super.postValue(value)
        MLog.i("postValue $value")
    }

}