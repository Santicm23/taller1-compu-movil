package com.example.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taller1.adapter.CountryAdapter
import com.example.taller1.databinding.ActivityCountriesBinding
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class CountriesActivity : AppCompatActivity() {

    companion object {
        private const val COUNTRIES_FILE = "paises.json"
    }

    private lateinit var binding: ActivityCountriesBinding

    private lateinit var countriesArray: MutableList<JSONObject>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val regionSelected = intent.getStringExtra("region")

        if (regionSelected !is String)
            throw Error("No region received")

        val title = "Countries of region: $regionSelected"
        binding.countriesTitle.text = title

        try {
            val jsonFile = loadCountriesByJson()
            countriesArray = filterCountries(jsonFile, regionSelected)
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = CountryAdapter(countriesArray)
    }

    private fun loadJSONFromAsset(assetName: String): String {
        val json: String = try {
            val inputStream = this.assets.open(assetName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, charset("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            ""
        }
        return json
    }

    @Throws(JSONException::class)
    fun loadCountriesByJson(): JSONObject {
        return JSONObject(loadJSONFromAsset(COUNTRIES_FILE))
    }

    private fun filterCountries(jsonFile: JSONObject, region: String): MutableList<JSONObject> {
        val countriesArray: MutableList<JSONObject> = ArrayList()
        val countries = jsonFile.getJSONArray("Countries")

        for (i in 0 until countries.length()) {
            val country = countries.getJSONObject(i)
            if (region.lowercase() == country.getString("Region").lowercase()) {
                countriesArray.add(country)
            }
        }

        return countriesArray
    }
}