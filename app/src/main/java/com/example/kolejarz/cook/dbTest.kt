package com.example.kolejarz.cook

import android.arch.lifecycle.Observer
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kolejarz.cookdb.ProductsViewModel

class dbTest : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.db_testpage)

        productsViewModel = ProductsViewModel.of(this).get(ProductsViewModel::class.java)

        productsViewModel.allProducts.observe(this, Observer { products ->
            // Update the cached copy of the products in the adapter.
            products?.let { adapter.setProducts(it) }
        })
    }

    private lateinit var productsViewModel: ProductsViewModel

    companion object {
        const val newProductsActivityRequestCode = 1
    }

    fab.setOnClickListener {
        val intent = Intent(this@dbTest, DbTestActivityTest::class.java)
        startActivityForResult(intent, newProductsActivityRequestCode)
    }
}