package com.example.homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val btnToActivity4 = findViewById<Button>(R.id.btn_to_activity4)
        btnToActivity4.setOnClickListener{
            startActivity(Intent(this, MainActivity4::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
            finishAffinity()
    }
}