package com.example.kolejarz.Adapter

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kolejarz.cook.ProductPage
import com.example.kolejarz.cook.R
import com.example.kolejarz.cook.R.layout.*
import com.example.kolejarz.model.Product
import kotlinx.android.synthetic.main.row_product_item.view.*

class ProductAdapter(private val context: Context?,private val dataSource: MutableList<Product>,private val fragment: Fragment) : BaseAdapter()
{
    private val inflater: LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(row_product_item, parent, false)

        val ft = fragment.fragmentManager!!.beginTransaction()
        val productName = rowView.product_name_item as TextView
        val productDescription = rowView.product_description_item as TextView

        val product = getItem(position) as Product

        productName.text = product.product_name
        productDescription.text = product.description

        rowView.detail_product.setOnClickListener {
            val productPage = ProductPage()
            val args = Bundle()
            args.putString("product_name",productName.text.toString())
            productPage.arguments = args

            ft.add(R.id.fragmentContainer,productPage).commit()

        }
        return rowView
    }
}