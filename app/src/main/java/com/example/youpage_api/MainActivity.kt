package com.example.youpage_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.youpage_api.adapters.mainRecyclerAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private val mViewModel: youPageViewModel by viewModels{RecyclerViewModelFactory(AppModule.repository)}
    private  lateinit var mViewPager : ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.mainRecyclerView)
        mViewPager = findViewById(R.id.viewPager)
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        mViewModel.widgetData.observe(this, Observer { apidata ->

            mRecyclerView.adapter = mainRecyclerAdapter(apidata,mViewPager)

        })


        mViewModel.fetchDataFromApi()

    }
}