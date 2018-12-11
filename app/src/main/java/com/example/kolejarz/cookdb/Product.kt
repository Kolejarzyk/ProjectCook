package com.example.kolejarz.cookdb

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Data class that represents our PRODUCTS.
 */

@Entity(tableName = "product_table")
class Product(@PrimaryKey
              @ColumnInfo(name = "Id") val id : Int,
              @ColumnInfo(name = "Name") val product_name: String,
              @ColumnInfo(name = "Full Name") val full_name: String,
              @ColumnInfo(name = "Description") val description: String,
              @ColumnInfo(name = "Calories") val calories: Int,
              @ColumnInfo(name = "Nutrients") val nutrients: String,
              @ColumnInfo(name = "Alergies") val alergies: String
                )