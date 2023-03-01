package com.example.a18_01_2023_recyclerviewwithviewtype

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(private var products : ArrayList<Product>) : RecyclerView.Adapter<RecyclerView.ProductsViewHolder>() {

    class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var txtPrice : TextView
        lateinit var txtTitle : TextView
        lateinit var imgProduct : ImageView

        init {
            imgProduct = itemView.findViewById(R.id.imgProduct)
            txtTitle = itemView.findViewById(R.id.txtTitle)
            txtPrice = itemView.findViewById(R.id.txtPrice)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ProductsViewHolder {
       var layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        var productView : View = layoutInflater.inflate(R.layout.product_view,null)
        var imageProductView : ImageView = productView.findViewById(R.id.imgProduct)
        return ProductsViewHolder(productView)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
       return products.size
    }
}