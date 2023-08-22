package com.example.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class CountryInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_info)

        val countrySelected = intent.getStringExtra("country")

        if (countrySelected !is String)
            throw Error("No region received")

        Log.d("country", countrySelected)
    }
}