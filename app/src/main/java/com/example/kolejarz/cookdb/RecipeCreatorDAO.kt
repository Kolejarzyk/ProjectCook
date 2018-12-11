package com.example.kolejarz.cookdb

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface RecipeCreatorDAO{

    @Query("SELECT * from recipe_in_creation_table ORDER BY `Recipe Name` ASC")
    fun getAllRecipes_in_creation(): LiveData<List<RecipeCreator>>

    @Insert
    fun insert(recipes: Recipes)

    @Query("DELETE FROM recipe_table")
    fun deleteAll()
}