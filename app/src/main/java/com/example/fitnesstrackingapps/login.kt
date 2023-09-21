package com.example.fitnesstrackingapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fitnesstrackingapps.databinding.ActivityLoginBinding

class login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var databaseHelper: databaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = databaseHelper(this)

        binding.loginBtn.setOnClickListener {
            val loginUsername = binding.signupUsername.text.toString()
            val loginPassword = binding.signupPassword.text.toString()
            loginDatabase(loginUsername, loginPassword)
        }
        binding.signupRedirectText.setOnClickListener {
            val intent = Intent(this, sign_up::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun loginDatabase(username: String, password: String) {
        val userExists = databaseHelper.readUser(username, password)
        if (userExists) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}