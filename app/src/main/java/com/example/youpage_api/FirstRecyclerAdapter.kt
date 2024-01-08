package com.example.youpage

import android.content.ClipData.Item
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youpage_api.Items
import com.example.youpage_api.MoreItems
import com.example.youpage_api.R

class FirstRecyclerAdapter(private val items: List<MoreItems>) :
    RecyclerView.Adapter<FirstRecyclerAdapter.FirstViewHolder>() {

    class FirstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val mContactImageView : ImageView = itemView.findViewById(R.id.contactImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.first_recycler_item, parent, false)
        return FirstViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.nameTextView.text = items[position].title
        Glide.with(holder.itemView.context)
            .load(items[position].img)  // Assuming item.img is the URL of the image
            .into(holder.mContactImageView)

        // Handle other properties for the firstRecycler type
    }

    override fun getItemCount() = items.size
}