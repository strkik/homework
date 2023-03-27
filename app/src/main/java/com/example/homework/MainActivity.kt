package com.example.homework

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnToActivity2 = findViewById<Button>(R.id.btm_to_activity2)
        btnToActivity2.setOnClickListener{
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }
}