package com.example.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val registerBtn = view.findViewById<Button>(R.id.registerBtn)
        val loginLayout2 = view.findViewById<TextInputLayout>(R.id.loginLayout2)
        val passwordLayout2 = view.findViewById<TextInputLayout>(R.id.passwordLayout2)
        val loginInput2 = view.findViewById<TextInputEditText>(R.id.loginInput2)
        val passwordInput2 = view.findViewById<TextInputEditText>(R.id.passwordInput2)
        registerBtn.setOnClickListener{
                if(loginInput2.text.isNullOrBlank()) {
                    loginLayout2.error = "login incorrect"
                }
                if(passwordInput2.text.isNullOrBlank()){
                    passwordLayout2.error = "password incorrect"
                }
                else{
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.appContainer, LoginFragment())
                        .commit()
                }
        }
        super.onViewCreated(view, savedInstanceState)

    }
}