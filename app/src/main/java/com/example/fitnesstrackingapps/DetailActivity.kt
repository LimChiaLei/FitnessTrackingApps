package com.example.fitnesstrackingapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    private lateinit var detailDesc: TextView
    private lateinit var detailTitle: TextView
    private lateinit var detailImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detailDesc = findViewById(R.id.detailDesc)
        detailTitle = findViewById(R.id.detailTitle)
        detailImage = findViewById(R.id.detailImage)

        val bundle = intent.extras
        if (bundle != null) {
            detailDesc.text = bundle.getString("Desc") // Retrieve it as a String
            detailImage.setImageResource(bundle.getInt("Image"))
            detailTitle.text = bundle.getString("Title")
        }
    }
}