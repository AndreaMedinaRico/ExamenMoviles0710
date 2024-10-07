package com.example.kotlin.examenmoviles0710.framework.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.examenmoviles0710.databinding.ActivityMainBinding

class MainActivity(): AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}