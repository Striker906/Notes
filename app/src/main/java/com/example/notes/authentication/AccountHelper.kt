package com.example.notes.authentication

import android.content.Context
import android.widget.Toast
import com.example.notes.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.qualifiers.ApplicationContext

class AccountHelper(private val context: Context) {

   val mAuth = FirebaseAuth.getInstance()

    fun signUpWithEmail(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                    sendEmailVerification(task.result.user!!)
                } else {
                    Toast.makeText(context, "${task.result.toString()}", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    private fun sendEmailVerification(user: FirebaseUser) {
        user.sendEmailVerification().addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(
                    context,
                    context.getString(R.string.sign_up_verification_success),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    context,
                    context.getString(R.string.sign_up_verification_error),
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }
}