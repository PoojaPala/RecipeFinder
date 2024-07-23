package com.example.recipefinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner


class MainActivity : AppCompatActivity() {

    private lateinit var spinnerCuisine: Spinner
    private lateinit var buttonGetRecipe: Button

    private val recipes = mapOf(
        "Italian" to listOf("Spaghetti Carbonara", "Margherita Pizza", "Lasagna"),
        "Chinese" to listOf("Sweet and Sour Pork", "Kung Pao Chicken", "Spring Rolls"),
        "Mexican" to listOf("Tacos", "Burritos", "Enchiladas"),
        "Indian" to listOf("Butter Chicken", "Palak Paneer", "Chole Bhature"),
        "French" to listOf("Croissants", "Ratatouille", "Quiche Lorraine"),
        "Japanese" to listOf("Sushi", "Ramen", "Tempura")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerCuisine = findViewById(R.id.spinner_cuisine)
        buttonGetRecipe = findViewById(R.id.button_get_recipe)

        val cuisines = resources.getStringArray(R.array.cuisines)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cuisines)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCuisine.adapter = adapter

        var selectedCuisine = ""

        spinnerCuisine.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selectedCuisine = cuisines[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        buttonGetRecipe.setOnClickListener {
            val randomRecipe = recipes[selectedCuisine]?.random()
            val intent = Intent(this, RecipeActivity::class.java).apply {
                putExtra("RECIPE", randomRecipe)
            }
            startActivity(intent)
        }
    }
}
