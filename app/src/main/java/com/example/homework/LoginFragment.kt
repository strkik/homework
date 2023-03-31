package com.example.homework

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val loginLayout = view.findViewById<TextInputLayout>(R.id.loginLayout)
        val loginInput = view.findViewById<TextInputEditText>(R.id.loginInput)
        val passwordLayout = view.findViewById<TextInputLayout>(R.id.passwordLayout)
        val passwordInput = view.findViewById<TextInputEditText>(R.id.passwordInput)
       // loginInput.
        val loginBtn = view.findViewById<Button>(R.id.loginBtn)
        val registrationBtn = view.findViewById<Button>(R.id.registrationBtn)
        registrationBtn.setOnClickListener{
            Log.w(
               "asd", "af"
            )
            parentFragmentManager.beginTransaction()
                .replace(R.id.appContainer, RegistrationFragment())
                .commit()
        }
        loginBtn.setOnClickListener{
            if(loginInput.text.isNullOrBlank()) {
                loginLayout.error = "login incorrect"
                }
            if(passwordInput.text.isNullOrBlank()){
                passwordLayout.error = "password incorrect"
            }
            else{
                parentFragmentManager.beginTransaction()
                    .replace(R.id.appContainer, MainFragment())
                    .commit()
            }
        }
//        val fragmentManager = supportFragmentManager.beginTransaction()
//        fragmentManager.add(R.id.appContainer, RegistrationFragment())
//        fragmentManager.commit()

    }


}
