package com.example.kolejarz.cookdb

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread

class ProductRepository(private val productDao: ProductDAO) {

        val allProduct: LiveData<List<Product>> = productDao.getAllProducts()
                @WorkerThread
                suspend fun insert(word: Product) {
                        productDao.insert(word)
                }

}