package com.example.kolejarz.cookdb

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ProductsDAO {

    @Query("SELECT * from products_table ORDER BY Products ASC")
    fun getAllProducts(): LiveData<List<Products>>

    @Insert
    fun insert(products: Products)

    @Query("DELETE FROM products_table")
    fun deleteAll()
}