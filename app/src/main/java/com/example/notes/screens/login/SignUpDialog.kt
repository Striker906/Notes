package com.example.notes.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.notes.databinding.SignUpCustomDialogBinding

class SignUpDialog(val loginViewModel: LoginViewModel) : DialogFragment() {

    private lateinit var binding: SignUpCustomDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignUpCustomDialogBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bttSignUp.setOnClickListener {
            val email = binding.etUsernameOrEmail.text.toString()
            val password = binding.etPassword.text.toString()
            Toast.makeText(this.requireContext(), "$email", Toast.LENGTH_SHORT).show()
            loginViewModel.signUp(email, password)

        }
    }
}