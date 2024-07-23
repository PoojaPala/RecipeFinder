package com.example.recipefinder



import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Calculations : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing UI elements
        val editTextNumber1: EditText = findViewById(R.id.editTextNumber1)
        val editTextNumber2: EditText = findViewById(R.id.editTextNumber2)
        val spinnerOperation: Spinner = findViewById(R.id.spinnerOperation)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)
        val textViewResult: TextView = findViewById(R.id.textViewResult)

        // Setting up the Spinner with operation options
        val operations = arrayOf("Add", "Subtract", "Multiply", "Divide")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, operations)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOperation.adapter = spinnerAdapter

        spinnerOperation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                // Handle item selection (if needed)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle no item selected case (if needed)
            }
        }

        // Setting up the Calculate button click listener
        buttonCalculate.setOnClickListener {
            val number1Text = editTextNumber1.text.toString()
            val number2Text = editTextNumber2.text.toString()

            // Ensure both inputs are not empty
            if (number1Text.isNotEmpty() && number2Text.isNotEmpty()) {
                val number1 = number1Text.toDouble()
                val number2 = number2Text.toDouble()
                val selectedOperation = spinnerOperation.selectedItem.toString()
                val result = when (selectedOperation) {
                    "Add" -> number1 + number2
                    "Subtract" -> number1 - number2
                    "Multiply" -> number1 * number2
                    "Divide" -> if (number2 != 0.0) number1 / number2 else "Cannot divide by zero"
                    else -> "Invalid operation"
                }
                textViewResult.text = "Result: $result"
            } else {
                textViewResult.text = "Please enter both numbers"
            }
        }
    }

}

