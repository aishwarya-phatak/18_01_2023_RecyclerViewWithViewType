package com.example.a18_01_2023_recyclerviewwithviewtype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var productsRecyclerView : RecyclerView
    private lateinit var productsAdapter: ProductsAdapter
    private lateinit var products : ArrayList<Product>
    private lateinit var users : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDataSet()
        initRecylerView()
    }
    fun initRecylerView(){
        productsRecyclerView = findViewById(R.id.productsRecyclerView)
        productsRecyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        productsAdapter = ProductsAdapter(products, users)
        productsRecyclerView.adapter = productsAdapter
    }
    fun initDataSet(){
        var i : Int
        users = ArrayList<User>()
        products = ArrayList<Product>()
        users.add(User(1,"Gauri","gauri@gmail.com"))
        users.add(User(2,"Durgesh","durgesh@gmail.com"))
        users.add(User(3,"Pravin","pravin@gmail.com"))
        users.add(User(4,"Nikhil","nikhil@gmail.com"))
        users.add(User(5,"Akanksha","akanksha@gmail.com"))

        for (i in 1..20){
        products.add(
            Product(i,
                R.drawable.ic_launcher_background,
                "Product $i",
                (i + 200) * 5)
        )
        }
    }

}