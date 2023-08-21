package com.example.taller1.adapter

import android.view.View
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.taller1.R
import com.example.taller1.databinding.CardItemBinding
import org.json.JSONObject

class CountryViewHolder(view: View) : ViewHolder(view) {

    val binding = CardItemBinding.bind(view)
    fun render(country: JSONObject) {
        binding.countryTitle.text = country.getString("Name")
        binding.nativeName.text = country.getString("NativeName")
        binding.alpha3Code.text = country.getString("Alpha3Code")
        binding.currencySymbol.text = country.getString("CurrencySymbol")
        Glide.with(binding.flagImg.context).load(country.getString("FlagPng")).into(binding.flagImg)
    }
}