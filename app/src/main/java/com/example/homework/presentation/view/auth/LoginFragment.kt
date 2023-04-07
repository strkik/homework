package com.example.homework.presentation.view.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.homework.R
import com.example.homework.databinding.FragmentDetailsBinding
import com.example.homework.databinding.FragmentLoginBinding
import com.example.homework.databinding.FragmentMainBinding
import com.example.homework.presentation.view.MainFragment
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {
    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return viewBinding.root
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
