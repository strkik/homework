package com.example.homework.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework.R
import com.example.homework.presentation.view.auth.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.add(R.id.appContainer, LoginFragment())
        fragmentManager.commit()

        //fun onClick(context: Context){
          //  val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

       // }
    }

}
