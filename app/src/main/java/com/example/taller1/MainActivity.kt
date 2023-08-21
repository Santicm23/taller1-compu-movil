package com.example.taller1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import com.example.taller1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var regionSpinner: Spinner
    lateinit var countriesButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        regionSpinner = binding.spinner
        countriesButton = binding.button

        countriesButton.setOnClickListener {
            val intent = Intent(applicationContext, CountriesActivity::class.java)
            intent.putExtra(
                "region",
                regionSpinner.selectedItem.toString()
            )
            startActivity(intent)
        }
    }
}