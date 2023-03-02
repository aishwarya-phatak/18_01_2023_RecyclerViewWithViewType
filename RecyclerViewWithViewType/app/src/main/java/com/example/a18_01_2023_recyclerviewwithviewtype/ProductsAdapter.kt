package com.example.a18_01_2023_recyclerviewwithviewtype

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(private var products : ArrayList<Product>, private var users : ArrayList<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val PRODUCT_VIEW_TYPE = 1
    val USER_VIEW_TYPE = 2

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

    class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var userImageView: ImageView
        lateinit var txtUsername : TextView
        lateinit var txtEmail : TextView
        init {
            userImageView = itemView.findViewById(R.id.userImageView)
            txtUsername = itemView.findViewById(R.id.txtUsername)
            txtEmail = itemView.findViewById(R.id.txtEmail)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == PRODUCT_VIEW_TYPE) {
            var layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
            var productView: View = layoutInflater.inflate(R.layout.product_view, null)
            var imageProductView: ImageView = productView.findViewById(R.id.imgProduct)
            var txtTitle: TextView = productView.findViewById(R.id.txtTitle)
            var txtPrice: TextView = productView.findViewById(R.id.txtPrice)

            return ProductsViewHolder(productView)
        }
            var layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
            var userView : View = layoutInflater.inflate(R.layout.user_view,null)
            var userImageView : ImageView = userView.findViewById(R.id.userImageView)
            var txtUsername : TextView = userView.findViewById(R.id.txtUsername)
            var txtEmail : TextView = userView.findViewById(R.id.txtEmail)
            return UsersViewHolder(userView)
    }

    override fun getItemViewType(position: Int): Int {
        if((position+1)%3 == 0){
            return USER_VIEW_TYPE
        }
        return PRODUCT_VIEW_TYPE
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ProductsViewHolder){
            var product = products[position - position/3]        //products.get(position)
             holder.txtTitle.text = product.name
             holder.txtPrice.text = "Rs ${product.price}"
             holder.imgProduct.setImageResource(R.drawable.ic_launcher_background)
        }
        if(holder is UsersViewHolder){
            var userPosition = (position+1)/3 - 1
            if(userPosition >= users.size){
                userPosition %= 5
            }
            holder.userImageView.setImageResource(R.drawable.ic_launcher_background)
            holder.txtUsername.text = users[userPosition].username
            holder.txtEmail.text = users[userPosition].email
        }
    }

    override fun getItemCount(): Int {
       return products.size + users.size
    }
}