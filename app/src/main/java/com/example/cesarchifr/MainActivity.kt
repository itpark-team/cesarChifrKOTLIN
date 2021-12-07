package com.example.cesarchifr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cesarchifr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var cesarViewModel = CesarViewModel()
        binding.viewModel = cesarViewModel
    }
}