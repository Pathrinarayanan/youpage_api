    package com.example.youpage_api.adapters

    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.TextView
    import androidx.recyclerview.widget.GridLayoutManager
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import androidx.viewpager.widget.ViewPager
    import com.example.youpage_api.R
    import com.example.youpage_api.models.Items

    class mainRecyclerAdapter(private val items: List<Items>,  private val mViewPager: ViewPager?  ) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        companion object {
            private const val TYPE_FIRST_RECYCLER = 0
            private const val TYPE_SECOND_RECYCLER = 1

        }

        inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
            val nestedRecyclerView: RecyclerView = itemView.findViewById(R.id.nestedRecyclerView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.main_recycler_data, parent, false)
            return MainViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val currentItem = items[position]

            when (holder) {
                is MainViewHolder -> {
                    holder.nameTextView.text = currentItem.title

                    // Set up the nested RecyclerView based on the type
                    when (currentItem.contentType) {
                        "single" -> {
                            val firstAdapter = currentItem.items?.let { FirstRecyclerAdapter(it) }
//                            System.out.print(currentItem.items)
                            holder.nestedRecyclerView.layoutManager = LinearLayoutManager(holder.nestedRecyclerView.context)
                            holder.nestedRecyclerView.adapter = firstAdapter
                        }
                        "contact" -> {
                            val secondAdapter = currentItem.items?.let { ContactRecyclerAdapter(it) }

                            holder.nestedRecyclerView.layoutManager = LinearLayoutManager(


                            holder.nestedRecyclerView.context,
                                LinearLayoutManager.HORIZONTAL,false
                            )

                            holder.nestedRecyclerView.adapter = secondAdapter
                        }

                        "grid" -> {
                            val fourthAdapter = currentItem.items?.let { PoliciesAdapter(it,mViewPager) }
                            holder.nestedRecyclerView.layoutManager = GridLayoutManager(holder.nestedRecyclerView.context,3,LinearLayoutManager.VERTICAL,false)
                            holder.nestedRecyclerView.adapter = fourthAdapter

                        }
                        else -> {}
                    }
                }
            }
        }

        override fun getItemCount() = items.size

        override fun getItemViewType(position: Int): Int {
            return when (items[position].contentType) {
                "single" -> TYPE_FIRST_RECYCLER
                "contact" -> TYPE_SECOND_RECYCLER
                else -> 10
            }
        }
    }

