package com.example.lab4
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.net.Uri
import android.widget.ImageButton
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var  buttonToasterFullName: Button
    lateinit var buttonTerminarJornada : Button
    lateinit var iconDirection : ImageButton
    lateinit var buttonDownload : Button
    lateinit var buttonDetails : Button
    lateinit var txtVRestaurant : TextView
    lateinit var txtVDirection : TextView
    lateinit var txtVHorario : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonToasterFullName = findViewById<Button>(R.id.btn_mainActivity_cardV_Iniciar)
        buttonTerminarJornada = findViewById<Button>(R.id.btn_mainActivity_FinishJ)
        buttonDownload = findViewById<Button>(R.id.btnDownload_mainActivity_download)
        iconDirection = findViewById(R.id.Ibtn_mainActivity_cardV_Restaurant)
        buttonDetails = findViewById<Button>(R.id.button_mainActivity_details)
        txtVRestaurant = findViewById(R.id.txtV_mainActivity_Restaurant)
        txtVDirection = findViewById(R.id.txtV_mainActivity_CardV_direction)
        txtVHorario = findViewById(R.id.txtV_mainActivity_cardV_Horario)
        initListeners()

    }

    private fun initListeners(){
        buttonToasterFullName.setOnClickListener{
            Toast.makeText(this, "Diego Andres Alonzo Medinilla", Toast.LENGTH_LONG).show()
        }
        buttonDownload.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName"))
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName"))
                startActivity(intent)
            }
        }
        iconDirection.setOnClickListener {
            val location = "http://maps.google.com/maps?q=loc:14.603835110728907,-90.48925677205315"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(location))
            startActivity(intent)
        }
        buttonDetails.setOnClickListener {

            val intent = Intent(this, DetailsActivity::class.java).apply{
                putExtra("nameRestaurante", txtVRestaurant.getText().toString())
                putExtra("directionRestaurante", txtVDirection.getText().toString())
                putExtra("horarioRestaurante", txtVHorario.getText().toString())
                putExtra("celularRestaurante", "23663702")
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent)
        }



    }
}
