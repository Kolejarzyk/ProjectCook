package com.example.kolejarz.cook

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kolejarz.DAO.AppDatabase
import kotlinx.android.synthetic.main.activity_product_page.view.*


class ProductPage : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val view: View = inflater.inflate(R.layout.activity_product_page, container, false)


        val value = arguments?.getString("product_name").toString()

        val currentProduct = AppDatabase.productDao.getByProductName(value)

        view.product_name.text = currentProduct?.product_name
        return view
    }
}