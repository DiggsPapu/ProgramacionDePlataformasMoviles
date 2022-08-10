package com.example.lab4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var  buttonToasterFullName: Button
    lateinit var buttonTerminarJornada : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonToasterFullName = findViewById<Button>(R.id.btn_mainActivity_cardV_Iniciar)
        buttonTerminarJornada = findViewById<Button>(R.id.btn_mainActivity_FinishJ)
        initListeners()
    }

    private fun initListeners(){
        buttonToasterFullName.setOnClickListener{
            Toast.makeText(this, "Diego Andres Alonzo Medinilla", Toast.LENGTH_LONG).show()
        }
    }
}