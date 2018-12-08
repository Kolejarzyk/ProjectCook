package com.example.kolejarz.cookdb

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.kolejarz.cook.R

class ProductsListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<ProductsListAdapter.ProductsViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var products = emptyList<Products>() // Cached copy of products

    inner class ProductsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productsItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return ProductsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val current = products[position]
        holder.productsItemView.text = current.Products
    }

    internal fun setProducts(products: List<Products>) {
        this.products = products
        notifyDataSetChanged()
    }

    override fun getItemCount() = products.size

    fun onCreate(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = ProductsListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}