package com.dingshaoshuai.jetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dingshaoshuai.jetpack.databinding.ActivityMainBinding
import com.dingshaoshuai.jetpack.lifecycle.MainLifecycleEventObserver
import com.dingshaoshuai.jetpack.lifecycle.MainLifecycleObserver
import com.dingshaoshuai.jetpack.viewmodel.MainAndroidViewModel

class MainActivity : AppCompatActivity() {

    //    private lateinit var viewModel: MainViewModel
    private lateinit var viewModel: MainAndroidViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(MainLifecycleObserver())
        lifecycle.addObserver(MainLifecycleEventObserver())
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
//            .get(MainViewModel::class.java)
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))
            .get(MainAndroidViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.liveData.observe(this) {
            MLog.i("LiveDate 值发生了变化，更新 UI")
        }
        viewModel.startThread()
    }
}


