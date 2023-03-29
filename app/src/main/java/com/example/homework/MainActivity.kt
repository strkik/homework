package com.example.homework

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.homework.MainActivity2.Companion.startMainActivity2
import com.example.homework.MainActivity4.Companion.startMainActivity4
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnToActivity2 = findViewById<Button>(R.id.btm_to_activity2)
        btnToActivity2.setOnClickListener{
            startActivity(Intent(this, MainActivity2::class.java))
        }
        val loginPanel = findViewById<TextInputLayout>(R.id.textLayout1)
        val passPanel = findViewById<TextInputLayout>(R.id.textLayout2)
        val login = findViewById<TextInputEditText>(R.id.inputField1)
        val password = findViewById<TextInputEditText>(R.id.inputField2)
        val alertDialog = AlertDialog.Builder( this)
            .setTitle("АЛЕРТ")
            .setPositiveButton("DA") { _, _ ->
            }
            .setNegativeButton("NET") { _, _ ->
            }
            .setMessage("логин: ${login.text.toString()} пароль: ${password.text.toString()}")

        val btnLogin = findViewById<Button>(R.id.loginButton)
        btnLogin.setOnClickListener{
            if(login.text.isNullOrBlank()){
                loginPanel.error = "login incorrect"
            }
            else if(password.text.isNullOrBlank()){
                passPanel.error = "password incorrect"
            }

            else{

                alertDialog.setMessage("логин: ${login.text.toString()} пароль: ${password.text.toString()}").show()
            }

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