package com.example.youpage_api.adapters

import android.R
import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.youpage_api.models.dialogContents
import com.example.youpage_api.models.dialogDetails


class CardRecyclerAdapter(private val context: Context, private val items: List<dialogContents>?) :
    RecyclerView.Adapter<CardRecyclerAdapter.CardViewHolder>() {

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textItem: TextView = itemView.findViewById(com.example.youpage_api.R.id.textItem)
        val textSubItem :TextView = itemView.findViewById(com.example.youpage_api.R.id.textSubItems)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(com.example.youpage_api.R.layout.card_recycler_item, parent, false)
        return CardViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        if (items?.get(position) != null)
            holder.textItem.text = items[position].header
        if (items != null) {
            val data: List<dialogDetails>? = items?.get(position)?.details
            val bulletinList = mutableListOf<String?>()

            data?.forEach { detail ->
                if (detail?.hasBullet == true) {
                    bulletinList.add("&#8226; ${detail.text}")
                } else {
                    bulletinList.add(detail?.text ?: "")  // Add the text without a bullet
                }
            }

            val stringBuilder = StringBuilder()

            bulletinList.forEach { item ->
                stringBuilder.append(item).append("<br/>")
                stringBuilder.append("<br/>")
            }

            val formattedText = stringBuilder.toString()
//            data?.forEach { detail ->
//                if (detail?.hasBullet == true) {
//                    bulletinList.add("<div style=\"display: flex; align-items: top;\">&#8226;</div><div style=\"display: flex; align-items: top; flex-direction: column;\">${detail.text}</div>")
//                } else {
//                    bulletinList.add("<div style=\"display: flex; align-items: top; flex-direction: column;\">${detail?.text ?: ""}</div>")
//                }
//            }
//
//            val stringBuilder = StringBuilder()
//
//            bulletinList.forEach { item ->
//                stringBuilder.append(item)
//            }
//
//            val formattedText = stringBuilder.toString()



            holder.textSubItem .text = Html.fromHtml(formattedText, Html.FROM_HTML_MODE_LEGACY)


        }
    }
    override fun getItemCount(): Int {
        if(items !=null)
            return items.size
        return 0
    }
}
