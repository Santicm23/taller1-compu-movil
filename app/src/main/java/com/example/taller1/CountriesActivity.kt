package com.example.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.taller1.databinding.ActivityCountriesBinding

class CountriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountriesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val regionSelected = intent.getStringExtra("region")

        if (regionSelected is String) {
            Log.d("region", regionSelected)
        } else {
            throw Error("No region received")
        }
    }
}