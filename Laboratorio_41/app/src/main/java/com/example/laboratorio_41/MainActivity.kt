package com.example.laboratorio_41

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    //Declaramos variables
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.button5);   //Inicio
        btn2 = findViewById(R.id.button3);   //ubicacion
        btn3 = findViewById(R.id.button);   //descargas
        btn4 = findViewById(R.id.button6);  //Detalels



        initListeners()
    }

    fun initListeners(){
        btn1.setOnClickListener{
            Toast.makeText(this, "Manuel Rodas", Toast.LENGTH_LONG).show()
        }

        btn2.setOnClickListener {
            val pin = "https://www.google.es/maps/place/Kloster+Majadas+Once/@14.599846,-90.580423,13z/data=!4m9!1m2!2m1!1skloster!3m5!1s0x8589a1adb87f9237:0xf163369b05aa1eb9!8m2!3d14.6208039!4d-90.5615092!15sCgdrbG9zdGVyWgkiB2tsb3N0ZXKSARFmb25kdWVfcmVzdGF1cmFudA?hl=es"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(pin))
            startActivity(intent)
        }

        btn3.setOnClickListener {
            val store = "https://play.google.com/store/apps/details?id=com.instagram.android&hl=es"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(store))
            startActivity(intent)
        }
        btn4.setOnClickListener{
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }




    }
}





















/*
class MainActivity : AppCompatActivity() {
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.button5)

        initListener();

    }

    fun initListener(){
        btn.setOnClickListener{
            Toast.makeText(this,"Manuel Rodas",Toast.LENGTH_LONG).show()
        }
    }
}

 */