package com.example.kolejarz.DAO

import com.example.kolejarz.model.Product

class ProductDao
{
    var productDao = mutableListOf<Product>()

    fun insertProduct(product: Product)
    {
        productDao.add(product)
    }


    fun updateProduct(product: Product,id: Int)
    {
        productDao.set(id,product)
    }


    fun deleteProduct(id: Int)
    {
        productDao.removeAt(id)
    }

    fun getProducts(): List<Product>
    {
        return productDao
    }
}
