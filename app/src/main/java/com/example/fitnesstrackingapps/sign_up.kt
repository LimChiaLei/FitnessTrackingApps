package com.example.fitnesstrackingapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fitnesstrackingapps.databinding.ActivitySignUpBinding

class sign_up : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var databaseHelper: databaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = databaseHelper(this)

        binding.signupBtn.setOnClickListener{
            val signupName = binding.signupName.text.toString()
            val signupEmail = binding.signupEmail.text.toString()
            val signupUsername = binding.signupUsername.text.toString()
            val signupPassword = binding.signupPassword.text.toString()
            signupDatabase(signupName,signupEmail,signupUsername,signupPassword)
        }

        binding.loginRedirectText.setOnClickListener {
            val intent =Intent(this, login::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun signupDatabase(signupName: String,signupEmail: String,username: String, password: String){
        val insertedRowId = databaseHelper.insertUser(signupName, signupEmail, username,password)
        if(insertedRowId != -1L){
            Toast.makeText(this,"Signup Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,login::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this, "Signup Failed",Toast.LENGTH_SHORT).show()
        }
    }
}