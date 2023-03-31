package com.example.homework

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

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
