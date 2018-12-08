package com.example.kolejarz.cookdb

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Data class that represents our items.
 */

@Entity(tableName = "products_table")
class Products(@PrimaryKey
               @ColumnInfo(name = "Products")
               val Products: String)