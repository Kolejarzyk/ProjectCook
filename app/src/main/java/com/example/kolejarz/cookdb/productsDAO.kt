package com.example.kolejarz.cookdb

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

@Dao
interface productsDAO {

    @Query("SELECT * from products")
    fun getAll(): List<products>

    @Insert(onConflict = REPLACE)
    fun insert(weatherData: products)

    @Query("DELETE from products")
    fun deleteAll()
}