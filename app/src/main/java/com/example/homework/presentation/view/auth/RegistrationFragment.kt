package com.example.homework.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.homework.R
import com.example.homework.databinding.FragmentLoginBinding
import com.example.homework.databinding.FragmentRegistrationBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistrationFragment : Fragment() {
    private var _viewBinding: FragmentRegistrationBinding? = null
    private val viewBinding get() = _viewBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentRegistrationBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return viewBinding.root
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