package com.example.fitnesstrackingapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Locale

class home : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: MutableList<DataClass>
    private lateinit var adapter: MyAdapter
    private lateinit var androidData: DataClass
    private lateinit var searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.search)

        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchList(newText)
                return true
            }
        })

        val gridLayoutManager = GridLayoutManager(this, 1)
        recyclerView.layoutManager = gridLayoutManager
        dataList = mutableListOf()

        androidData = DataClass("Keep Fit", getString(R.string.keep_fit_plan), "", R.drawable.meal_plan)
        dataList.add(androidData)

        androidData = DataClass("7-Day Weight Loss Meal Plan", getString(R.string.weight_loss_plan), "", R.drawable.meal_plan)
        dataList.add(androidData)

        androidData = DataClass("High-Protein Meal Plan for Muscle Building", getString(R.string.muscle_building_plan), "", R.drawable.meal_plan)
        dataList.add(androidData)

        adapter = MyAdapter(this, dataList)
        recyclerView.adapter = adapter

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        bottomNavigationView.selectedItemId = R.id.home // from bottom menu

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> true
                R.id.workout -> {
                    startActivity(Intent(applicationContext, workout::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_left)
                    finish()
                    true
                }
                R.id.chart -> {
                    startActivity(Intent(applicationContext, chart::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_in_left)
                    finish()
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
    private fun searchList(text: String?) {
        val dataSearchList = mutableListOf<DataClass>()
        for (data in dataList) {
            if (data.dataTitle.toLowerCase(Locale.ROOT).contains(text?.toLowerCase(Locale.ROOT) ?: "")) {
                dataSearchList.add(data)
            }
        }
        if (dataSearchList.isEmpty()) {
            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show()
        } else {
            adapter.setSearchList(dataSearchList)
        }
    }

}