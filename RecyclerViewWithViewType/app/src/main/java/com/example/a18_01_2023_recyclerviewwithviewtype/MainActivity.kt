package com.example.a18_01_2023_recyclerviewwithviewtype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var productsRecyclerView : RecyclerView
    init {
        productsRecyclerView = findViewById(R.id.productsRecyclerView)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}