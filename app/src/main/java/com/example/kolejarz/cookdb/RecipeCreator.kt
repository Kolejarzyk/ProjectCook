package com.example.kolejarz.cookdb

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.PrimaryKey
import java.sql.Date

/**
 * Data class that represents our RECIPES IN CREATOR.
 */

@Entity(tableName = "recipe_in_creation_table",
    foreignKeys = [
        ForeignKey(entity = Product::class,
            parentColumns = ["product_name"],
            childColumns = ["product"],
            onDelete = CASCADE)])
class RecipeCreator(@PrimaryKey
              @ColumnInfo(name = "Recipe-in-creation Id") val id : Int,
              @ColumnInfo(name = "Recipe Name") val recipe_name: String,
              @ColumnInfo(name = "Product Name") val product: String,
              @ColumnInfo(name = "Date of Creation") val date: Date
)