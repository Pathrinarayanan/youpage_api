package com.example.youpage_api.adapters



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.youpage_api.R
import com.example.youpage_api.models.MoreDialogues
import com.example.youpage_api.models.Page

class CardPagerAdapter(private val pages: List<MoreDialogues>?, private val mViewPager: ViewPager? ) : PagerAdapter() {

    override fun getCount(): Int {
        if(pages!=null)
            return pages.size
        return  0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var view = LayoutInflater.from(container.context).inflate(R.layout.card_layout, container, false)
            container.addView(view)
            val holder = PageViewHolder(view)

            holder.bind(pages?.get(position))
           val close = view.findViewById<Button>(R.id.closeButton)
            close.setOnClickListener{
               container.removeView(view)
                if(mViewPager!=null)
                    mViewPager.visibility = View.GONE

            }
            return view
        }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    inner class PageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val mCardRecyclerView :RecyclerView = itemView.findViewById(R.id.cardRecyclerView)
        fun bind(page: MoreDialogues?) {
            if(page!=null)
                titleTextView.text = page.title
//            val textItems = listOf("Item 1", "Item 2", "Item 3", "Item 4")


            mCardRecyclerView.layoutManager = LinearLayoutManager(itemView.context)
            if (page != null) {
                if(page.contents !=null)
                    mCardRecyclerView.adapter =  CardRecyclerAdapter(itemView.context,page.contents)
            }
        }
    }
}
