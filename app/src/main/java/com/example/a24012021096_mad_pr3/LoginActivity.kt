package com.example.a24012021096_mad_pr3.ui.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a24012021096_mad_pr3.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(
            R.id.editTextTextEmailAddress
        )

        val password = findViewById<EditText>(
            R.id.editTextNumberPassword
        )

        val loginButton = findViewById<Button>(
            R.id.button4
        )

        loginButton.setOnClickListener {

            val emailText = email.text.toString()
            val passwordText = password.text.toString()

            if (emailText.isEmpty() || passwordText.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please enter Email and Password",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                Toast.makeText(
                    this,
                    "Login Successful",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}