package com.example.homework

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val text2 = intent.extras?.get(TEXT1)
        supportActionBar?.setTitle(text2.toString())
    }
    companion object{
        private const val TEXT1 = "text1"
        fun startMainActivity4(context: Context, text1: String){
            val intent = Intent(context, MainActivity4::class.java)

            intent.putExtra(TEXT1, text1)
            context.startActivity(intent)

        }
    }
}