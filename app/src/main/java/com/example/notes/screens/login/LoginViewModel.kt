package com.example.notes.screens.login

import androidx.lifecycle.ViewModel
import com.example.notes.authentication.AccountHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val accountHelper: AccountHelper
) :ViewModel(){

    fun signUp(email: String, password: String) {
        accountHelper.signUpWithEmail(email, password)
    }
}