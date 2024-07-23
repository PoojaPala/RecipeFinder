package com.example.recipefinder

    import android.R
    import android.content.Intent
    import android.os.Bundle
    import android.widget.Button
    import androidx.appcompat.app.AppCompatActivity
    import com.example.recipefinder.Calculations
    import com.example.recipefinder.RecipeActivity
    import com.example.recipefinder.MainActivity
    import com.example.recipefinder.MultiuAppLauncher
    class MultiuAppLauncher : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_multiuapplauncher)

            val buttonLaunchRecipeFinder: Button = findViewById(R.id.button_launch_recipe_finder)
            val buttonLaunchTemperatureConverter: Button = findViewById(R.id.button_calculations)

            buttonLaunchRecipeFinder.setOnClickListener {
                val recipeFinderIntent = Intent(this, RecipeActivity::class.java)
                recipeFinderIntent.putExtra("initial_data", "Start with Recipe Finder")
                startActivity(recipeFinderIntent)
            }

            buttonLaunchTemperatureConverter.setOnClickListener {
                val temperatureConverterIntent = Intent(this, Calculations::class.java)
                temperatureConverterIntent.putExtra("initial_data", "Start with Temperature Converter")
                startActivity(temperatureConverterIntent)
            }
        }
    }

}