package com.example.youpage_api.models


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.youpage_api.R

class PoliciesAdapter(private val items: List<MoreItems>) :
    RecyclerView.Adapter<PoliciesAdapter.FirstViewHolder>() {

    class FirstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
//        val mContactImageView : ImageView = itemView.findViewById(R.id.contactImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.policies_item_recycler, parent, false)
        return FirstViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.nameTextView.text = items[position].title
//        holder.mContactImageView.setImageResource(items[position].image)
        // Handle other properties for the firstRecycler type

    }

    override fun getItemCount() = items.size
}