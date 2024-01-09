package com.example.youpage_api.adapters


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.youpage_api.R
import com.example.youpage_api.models.MoreItems
import com.example.youpage_api.models.Page

class PoliciesAdapter(private val items: List<MoreItems>,  private val mViewPager: ViewPager? ) :
    RecyclerView.Adapter<PoliciesAdapter.FirstViewHolder>() {

   inner class FirstViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
//        val mContactImageView : ImageView = itemView.findViewById(R.id.contactImageView)
init {
    // Set a click listener for the entire item view
    itemView.setOnClickListener {
        val position = adapterPosition
        if (position != RecyclerView.NO_POSITION) {
            onItemClick(mViewPager,position)
//                    Toast.makeText(itemView.context,items[position].text.toString(),Toast.LENGTH_SHORT).show()
        }
    }
}

        fun onItemClick(mViewPager: ViewPager?, position: Int) {
            val currentDialogTabs =items[position].dialogTabs


            if(mViewPager !=null && currentDialogTabs !=null) {
                mViewPager.adapter =  CardPagerAdapter(currentDialogTabs,mViewPager)
                mViewPager.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.policies_item_recycler, parent, false)
        return FirstViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.nameTextView.text = items[position].title

    }

    override fun getItemCount() = items.size

}