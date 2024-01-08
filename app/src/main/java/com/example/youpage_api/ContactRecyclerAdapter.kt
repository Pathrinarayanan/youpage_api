package com.example.youpage

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

class ContactRecyclerAdapter(private val items: List<MoreItems>) :
    RecyclerView.Adapter<ContactRecyclerAdapter.ContactViewHolder>() {

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView2)
        val mContactImageView : ImageView = itemView.findViewById(R.id.contactImageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_recycler_item, parent, false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.nameTextView.text = items[position].title
//        holder.mContactImageView.setImageResource(items[position].image)
        Glide.with(holder.itemView.context)
            .load(items[position].img)  // Assuming item.img is the URL of the image
            .into(holder.mContactImageView)

    }

    override fun getItemCount() = items.size
}