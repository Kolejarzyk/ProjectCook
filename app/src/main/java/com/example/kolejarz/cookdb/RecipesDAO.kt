package com.example.kolejarz.cookdb

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface RecipesDAO {

    @Query("SELECT * from recipe_table ORDER BY `Recipe Name` ASC")
    fun getAllRecipes(): LiveData<List<Recipes>>

    @Insert
    fun insert(recipes: Recipes)

    @Query("DELETE FROM recipe_table")
    fun deleteAll()
}