package com.example.kolejarz.cookdb

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import java.sql.Date

/**
 * Data class that represents our RECIPES.
 */

@Entity(tableName = "recipe_table",
    foreignKeys = [
        ForeignKey(entity = User::class,
            parentColumns = ["nickname"],
            childColumns = ["user_name"],
            onDelete = ForeignKey.CASCADE
        )])
class Recipes(@PrimaryKey
           @ColumnInfo(name = "recipe_id") val id : Int,
           @ColumnInfo(name = "Recipe Name") val recipe_name: String,
           @ColumnInfo(name = "Creator") val user_name: String,
           @ColumnInfo(name = "Date of Creation") val date: Date
)