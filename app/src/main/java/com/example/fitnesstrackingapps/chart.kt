package com.example.fitnesstrackingapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class chart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        bottomNavigationView.selectedItemId = R.id.chart // from bottom menu

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    startActivity(Intent(applicationContext, home::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_left)
                    finish()
                    true
                }
                R.id.workout -> {
                    startActivity(Intent(applicationContext, workout::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_left)
                    finish()
                    true
                }
                R.id.chart -> {
                    true
                }
                R.id.profile -> {
                    startActivity(Intent(applicationContext, profile::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_left)
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}