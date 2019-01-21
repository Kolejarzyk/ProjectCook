package com.example.kolejarz.DAO

import com.example.kolejarz.model.Product

/**
 * Data Access Object of Product.
 */
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

    fun getProducts(): MutableList<Product>
    {
        return productDao
    }

    fun getById(id: Int) : Product
    {
        return productDao[id]
    }

    fun getByProductName(name: String): Product?
    {
        return productDao.find { product -> product.product_name == name }
    }
}
