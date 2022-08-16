package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    lateinit var btnInitV : Button
    lateinit var txtVCall: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        btnInitV = findViewById(R.id.btn_detailsActivity_IniciarVista)

        txtVCall = findViewById(R.id.txtV_detailsActivity_llamar)
        initListeners()
    }
    private fun initListeners(){
        btnInitV.setOnClickListener {
            
        }
        txtVCall.setOnClickListener {

        }
    }
}