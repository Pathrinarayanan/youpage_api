package com.example.youpage_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youpage.mainRecyclerAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private val mViewModel: youPageViewModel by viewModels{RecyclerViewModelFactory(AppModule.repository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.mainRecyclerView)
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        mViewModel.widgetData.observe(this, Observer { apidata ->
//            mDataAdapter.setData(widgets)
//            System.out.println(apidata)
            mRecyclerView.adapter = mainRecyclerAdapter(apidata)

        })


        mViewModel.fetchDataFromApi()

    }
}