package com.example.testapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val natureList = listOf(
            NatureItem(R.drawable.nature, "Forest", "A beautiful green forest."),
            NatureItem(R.drawable.nature, "Mountain", "A tall snowy mountain."),
            NatureItem(R.drawable.nature, "River", "A peaceful flowing river.")
        )

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = NatureAdapter(natureList) { selectedItem ->

            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("title", selectedItem.title)
            intent.putExtra("description", selectedItem.description)
            intent.putExtra("image", selectedItem.image)
            startActivity(intent)
        }
    }
}