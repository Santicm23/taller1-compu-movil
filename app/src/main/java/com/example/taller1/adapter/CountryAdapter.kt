package com.example.taller1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taller1.R
import org.json.JSONObject

class CountryAdapter (private val countries: List<JSONObject>) : RecyclerView.Adapter<CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val layouteInflater = LayoutInflater.from(parent.context)
        return CountryViewHolder(layouteInflater.inflate(R.layout.card_item, parent, false))
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.render(countries[position])
    }

    override fun getItemCount(): Int = countries.size

}