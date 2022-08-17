package com.example.lab4

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar

class DetailsActivity : AppCompatActivity() {
    lateinit var btnInitV : Button
    lateinit var  txtRestaurant : TextView
    lateinit var  txtHorario : TextView
    lateinit var  txtDirection : TextView
    lateinit var txtVCall: TextView
    lateinit var txtVLlamar : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        btnInitV = findViewById(R.id.btn_detailsActivity_IniciarVista)
        val restaurant: Restaurant = intent.getSerializableExtra("restaurant") as Restaurant

        val intent = getIntent().getStringExtra("nameRestaurante")
        txtVCall = findViewById<TextView?>(R.id.txtV_detailsActivity_cel).apply {
            text = getIntent().getStringExtra("celularRestaurante")
        }
        txtRestaurant = findViewById<TextView?>(R.id.txtV_detailsActivity_Restaurant).apply {
            text = restaurant.name.toString()
        }
        txtHorario = findViewById<TextView?>(R.id.txtV_detailsActivity_horario).apply {
            text = restaurant.horario.toString()
        }
        txtDirection = findViewById<TextView?>(R.id.txtV_detailsActivity_direccion).apply {
            text = restaurant.direction.toString()
        }
        txtVLlamar = findViewById(R.id.txtV_detailsActivity_llamar)
        initListeners()
    }
    private fun initListeners(){
        btnInitV.setOnClickListener {
            CheckCameraPermission()
        }
        txtVLlamar.setOnClickListener {
            val phoneNumber = getIntent().getStringExtra("celularRestaurante")
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(intent)
        }
    }

    private fun hasCameraPermission()=
        ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED
    private fun hasWriteExternalPermission () =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    private fun CheckCameraPermission(){
        if (!hasCameraPermission()){
            checkRequestRationale(Manifest.permission.CAMERA)
        }
        else {
            Toast.makeText(this, "Permiso otorgado, ya puedes abrir camara", Toast.LENGTH_LONG).show()
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cameraIntent)
        }
    }
    private fun checkRequestRationale(permission: String){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if (shouldShowRequestPermissionRationale(permission)){
                Snackbar.make(
                    btnInitV,
                    "El acceso es necesario para correr la aplicacion",
                    Snackbar.LENGTH_INDEFINITE
                ).setAction("Ok") {
                    ActivityCompat.requestPermissions(this, arrayOf(permission), 0)
                }.show()
                }
            else{
                ActivityCompat.requestPermissions(this, arrayOf(permission), 0)
            }
        }
    }
}