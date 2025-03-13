package com.example.practica6popcorn

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.practica6popcorn.catalogo.PeliculaAdapter
import com.example.practica6popcorn.databinding.ActivityDetallePeliculaBinding

class detalle_pelicula : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val iv_pelicula_image: ImageView = findViewById(R.id.iv_pelicula_imagen)
        val tv_nombre_pelicula: TextView = findViewById(R.id.tv_nombre_pelicula)
        val tv_pelicula_desc: TextView = findViewById(R.id.tv_pelicula_desc)
        val seatsLeft: TextView = findViewById(R.id.seatsLeft)
        val buyTickets: Button = findViewById(R.id.buyTickets)

        val bundle = intent.extras

        var ns = 0

        if(bundle!=null){
            ns =  bundle.getInt("numberSeats")
            iv_pelicula_image.setImageResource(bundle.getInt("header"))
            tv_nombre_pelicula.setText(bundle.getString("titulo"))
            tv_pelicula_desc.setText(bundle.getString("sinopsis"))
            seatsLeft.setText("$ns seats available")
//            seatsLeft.setText(String.format("%d seats available", bundle.getInt("numberSeats")));
        }


        if(ns==0){
            buyTickets.isActivated = false

        }else{
            buyTickets.setOnClickListener {
                val intent: Intent = Intent(this, SeatSelection::class.java)



            }
        }

    }



}