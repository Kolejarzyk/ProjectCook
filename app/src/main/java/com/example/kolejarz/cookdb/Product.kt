package com.example.kolejarz.cookdb

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Data class that represents our items.
 */

@Entity(tableName = "product_table")
class Product(@PrimaryKey
                @ColumnInfo(name = "Id")
                val id : Int,
               @ColumnInfo(name = "Name")
               val Name: String)