package com.example.kolejarz.Adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kolejarz.cook.R
import com.example.kolejarz.model.Product
import kotlinx.android.synthetic.main.row_recipe_detail_product_item.view.*


class ProductRecipeAdapter(private val context: Context?, private val dataSource: MutableList<Product?>, private val fragment: Fragment) : BaseAdapter()
{
    private val inflater: LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any? {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.row_recipe_detail_product_item, parent, false)

        val productName = rowView.product_name_item as TextView

        val product = getItem(position) as Product

        productName.text = product.product_name

        return rowView
    }

}