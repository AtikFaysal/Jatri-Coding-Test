package com.jatri.codingtest.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jatri.codingtest.R
import com.jatri.codingtest.core.BaseActivity
import com.jatri.codingtest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun initialize() {}

    override fun setToolbarTitle(title: String) {
        setToolbarTitle(title, binding.appToolbar.tvTitle)
    }
}