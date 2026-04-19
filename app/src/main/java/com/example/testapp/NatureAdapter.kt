package com.example.testapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NatureAdapter(
    private val natureList: List<NatureItem>,
    private val onClick: (NatureItem) -> Unit
) : RecyclerView.Adapter<NatureAdapter.NatureViewHolder>() {

    class NatureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.itemImage)
        val title: TextView = itemView.findViewById(R.id.itemTitle)
        val description: TextView = itemView.findViewById(R.id.itemDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NatureViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_nature, parent, false)
        return NatureViewHolder(view)
    }

    override fun onBindViewHolder(holder: NatureViewHolder, position: Int) {
        val item = natureList[position]

        holder.image.setImageResource(item.image)
        holder.title.text = item.title
        holder.description.text = item.description

        holder.itemView.setOnClickListener {
            onClick(item)
        }
    }

    override fun getItemCount(): Int = natureList.size
}