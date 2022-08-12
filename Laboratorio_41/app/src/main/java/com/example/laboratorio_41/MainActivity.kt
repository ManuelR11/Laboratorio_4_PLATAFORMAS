package com.example.laboratorio_41

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

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