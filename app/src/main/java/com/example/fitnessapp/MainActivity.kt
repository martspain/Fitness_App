package com.example.fitnessapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    //Attributes

    private lateinit var refresh_but: Button
    private lateinit var round_but: Button
    private lateinit var trophy_image: ImageView
    private var lap = 0
    private var maxLap = 20
    private lateinit var results: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        round_but = findViewById(R.id.tapButton)
        refresh_but = findViewById(R.id.tapButton2)
        results = findViewById(R.id.resultText)
        trophy_image = findViewById(R.id.trophy_view)

        results.text = lap.toString()
        trophy_image.setImageResource(R.drawable.moneda)
        trophy_image.visibility= View.GONE


        round_but.setOnClickListener{
            this.newLap()
        }

        refresh_but.setOnClickListener{
            this.refreshAll()
        }

        round_but.setOnLongClickListener{
            Toast.makeText(this@MainActivity, "Le hacen falta ${maxLap-lap} vueltas para terminar..", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
    }

    private fun newLap(){
        if (this.lap < this.maxLap){
            lap++
            results.text = lap.toString()
            if (this.lap == 10){
                trophy_image.visibility=View.VISIBLE
                Toast.makeText(this@MainActivity,"Ya llegó a 10 vueltas! Falta poco!", Toast.LENGTH_SHORT).show()
            }
            if(this.lap == 11){
                trophy_image.visibility=View.GONE
            }
            if(lap == 20){
                trophy_image.setImageResource(R.drawable.trophy)
                trophy_image.visibility= View.VISIBLE
                Toast.makeText(this@MainActivity, "Ha logrado su objetivo! Felicidades!", Toast.LENGTH_SHORT).show()
            }
        }
        else{
            Toast.makeText(this@MainActivity, "No puede agregar más vueltas, porfavor reinicie", Toast.LENGTH_SHORT).show()
        }
    }
    private fun refreshAll(){
        lap = 0
        results.text = lap.toString()
        trophy_image.setImageResource(R.drawable.moneda)
        trophy_image.visibility= View.GONE
    }
}
