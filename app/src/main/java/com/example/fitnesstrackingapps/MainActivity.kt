package com.example.fitnesstrackingapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wlcButton = findViewById<Button>(R.id.welcome)

        wlcButton.setOnClickListener(View.OnClickListener {
            // Define the action to perform when the button is clicked
            val intent = Intent(this, home::class.java) // HomeActivity is the name of your home screen Activity
            startActivity(intent)
        })
    }
}