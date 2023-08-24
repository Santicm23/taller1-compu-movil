package com.example.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.taller1.databinding.ActivityCountryInfoBinding
import org.json.JSONObject

class CountryInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountryInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCountryInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countrySelected = intent.getStringExtra("country")

        if (countrySelected !is String)
            throw Error("No region received")

        val infoCountry = JSONObject(countrySelected)

        binding.countryName.text = "${infoCountry.getString("Name")} - ${infoCountry.getString("NativeName")}"
        binding.alphaCodes.text = "${infoCountry.getString("Alpha2Code")} - ${infoCountry.getString("Alpha3Code")}"
        binding.language.text = infoCountry.getString("NativeLanguage")
        binding.regions.text = "${infoCountry.getString("Region")}/${infoCountry.getString("SubRegion")}"
        binding.currencyInfo.text = "${infoCountry.getString("CurrencyName")} (${infoCountry.getString("CurrencySymbol")})"
        Glide.with(binding.imageView.context).load(infoCountry.getString("FlagPng")).into(binding.imageView)
    }
}