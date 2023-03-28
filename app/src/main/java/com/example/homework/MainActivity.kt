package com.example.homework

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.homework.MainActivity2.Companion.startMainActivity2
import com.example.homework.MainActivity4.Companion.startMainActivity4

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
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_item, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.app_menu1){
            startMainActivity2(this, "ТЕКСТ")
        }
        if(item.itemId == R.id.app_menu2){
            startMainActivity2(this, "Clicked second item")
        }
        if(item.itemId == R.id.app_menu3){
            finishAffinity()
        }
        if(item.itemId == R.id.app_menu4){
            startMainActivity4(this, "АОР")
        }
        return super.onOptionsItemSelected(item)
    }

}