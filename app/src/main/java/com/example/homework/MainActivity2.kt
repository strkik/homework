package com.example.homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val btnToActivity3 = findViewById<Button>(R.id.btn_to_activity3)
        btnToActivity3.setOnClickListener{
            startActivity(Intent(this, MainActivity3::class.java))
        }
    }
}