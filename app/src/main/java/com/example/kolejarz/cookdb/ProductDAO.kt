package com.example.kolejarz.cookdb

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ProductDAO {

    @Query("SELECT * from product_table ORDER BY Name ASC")
    fun getAllProducts(): LiveData<List<Products>>

    @Insert
    fun insert(products: Products)

    @Query("DELETE FROM product_table")
    fun deleteAll()
}