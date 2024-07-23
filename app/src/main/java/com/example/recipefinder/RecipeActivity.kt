package com.example.recipefinder

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        val textRecipe: TextView = findViewById(R.id.text_recipe)
        val buttonBack: Button = findViewById(R.id.button_back)

        val recipe = intent.getStringExtra("RECIPE")
        textRecipe.text = recipe

        buttonBack.setOnClickListener {
            finish()
        }
    }
}
