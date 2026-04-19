package com.example.testapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val titleText = findViewById<TextView>(R.id.titleText)
        val descriptionText = findViewById<TextView>(R.id.descriptionText)
        val websiteText = findViewById<TextView>(R.id.websiteText)
        val emailText = findViewById<TextView>(R.id.emailText)

        // Receive data from intent
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")

        titleText.text = title
        descriptionText.text = description

        // Implicit Intent 1: Open Website
        websiteText.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.nationalgeographic.com")
            startActivity(intent)
        }

        // Implicit Intent 2: Send Email
        emailText.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:nature@example.com")
            startActivity(intent)
        }
    }
}