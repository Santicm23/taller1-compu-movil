package com.example.taller1.adapter

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.taller1.CountryInfoActivity
import com.example.taller1.databinding.CardItemBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONObject

class CountryViewHolder(view: View) : ViewHolder(view) {

    private val binding = CardItemBinding.bind(view)

    private lateinit var floatingActionButton: FloatingActionButton
    fun render(country: JSONObject) {
        binding.countryTitle.text = country.getString("Name")
        binding.nativeName.text = country.getString("NativeName")
        binding.alpha3Code.text = country.getString("Alpha3Code")
        val currency = "${country.getString("CurrencyName")} (${country.getString("CurrencySymbol")})"
        binding.currencySymbol.text = currency
        Glide.with(binding.flagImg.context).load(country.getString("FlagPng")).into(binding.flagImg)

        itemView.setOnClickListener {
            val intent = Intent(it.context, CountryInfoActivity::class.java)
            intent.putExtra(
                "country",
                country.toString()
            )
            it.context.startActivity(intent)
        }
        floatingActionButton = binding.call
        floatingActionButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:+${country.getString("NumericCode")}")
            it.context.startActivity(intent)
        }
    }
}