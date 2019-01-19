package com.example.kolejarz.cook

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kolejarz.Adapter.ProductAdapter
import com.example.kolejarz.DAO.AppDatabase
import com.example.kolejarz.model.Product
import kotlinx.android.synthetic.main.activity_productlist_page.view.*

class ProductListPage : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val view : View = inflater.inflate(R.layout.activity_productlist_page,container,false)

        var productList : MutableList<Product> = AppDatabase.productDao.getProducts()

        val adapter = ProductAdapter(this.context,productList,this)

        view.product_list_view.adapter = adapter

        return view

    }

}