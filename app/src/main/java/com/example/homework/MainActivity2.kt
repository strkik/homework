package com.example.homework

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val btnToActivity3 = findViewById<Button>(R.id.btn_to_activity3)
        val intentExtras = intent.extras?.get(TEXTVIEW)
        supportActionBar?.setTitle(intentExtras.toString())
        val textView = findViewById<TextView>(R.id.textView1)
        textView.text = intentExtras.toString()
        btnToActivity3.setOnClickListener{
            startActivity(Intent(this, MainActivity3::class.java))
        }
    }
    companion object {
        private const val TEXTVIEW = "TEXTVIEWKEY"
        fun startMainActivity2(context: Context, textStr: String){
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(TEXTVIEW, textStr)
            context.startActivity(intent)
        }

    }
}
