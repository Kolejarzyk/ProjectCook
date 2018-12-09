package com.example.kolejarz.cook

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kolejarz.cookdb.ProductsViewModel

class DBTest : AppCompatActivity()  {

    private lateinit var productsViewModel: ProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.db_testpage)

        productsViewModel = ProductsViewModel(this).get//ProductsViewModel.of(this).get(ProductsViewModel::class.java)

        productsViewModel.allProducts.observe(this, Observer { products ->
            // Update the cached copy of the products in the adapter.
            products?.let { adapter.setProducts(it) }
        })
    }



    companion object {
        const val newProductsActivityRequestCode = 1
    }

    fab.setOnClickListener {
        val intent = Intent(this@DBTest, DbTestActivityTest::class.java)
        startActivityForResult(intent, newProductsActivityRequestCode)
    }
}