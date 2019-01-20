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

/**
 * Class responsible for Product's list fragment.
 */
class ProductListPage : Fragment() {

    /**
     * LayoutInflater is one of the Android System Services
     * that is responsible for taking your XML files that define a layout,
     * and converting them into View objects.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.activity_productlist_page,container,false)

        /**
         * gets product's list from database.
         */
        var productList : MutableList<Product> = AppDatabase.productDao.getProducts()

        /**
         * Connects to Product's adapter.
         */
        val adapter = ProductAdapter(this.context,productList,this)
        view.product_list_view.adapter = adapter

        return view
    }
}