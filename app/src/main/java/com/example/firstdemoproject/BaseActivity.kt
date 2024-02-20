package com.example.firstdemoproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<viewBinding : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: viewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getActivityView()
        setContentView(binding.root)
        supportActionBar?.hide()
        initViews(savedInstanceState)
    }

    abstract fun getActivityView(): viewBinding

    abstract fun initViews(savedInstanceState: Bundle?)
    override fun onDestroy() {
        super.onDestroy()

    }

}