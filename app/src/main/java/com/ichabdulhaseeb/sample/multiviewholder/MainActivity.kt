package com.ichabdulhaseeb.sample.multiviewholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ichabdulhaseeb.sample.multiviewholder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()
    }

    private fun setRecyclerView(){

        val mList : ArrayList<String> = ArrayList()

        mList.add("Hello World")
        for(i in 1..100)
            mList.add(i.toString())
        mList.add("End")

        val recyclerView = binding.rv
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(mList)
        recyclerView.adapter = adapter

    }
}