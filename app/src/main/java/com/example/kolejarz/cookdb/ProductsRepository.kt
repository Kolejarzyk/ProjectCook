package com.example.kolejarz.cookdb

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread

class ProductsRepository(private val productsDAO: ProductsDAO) {

    val allProducts: LiveData<List<Products>> = productsDAO.getAllProducts()

    @WorkerThread
    suspend fun insert(products: Products) {
        productsDAO.insert(products)
    }
}