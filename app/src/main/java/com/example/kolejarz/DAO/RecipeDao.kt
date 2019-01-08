package com.example.kolejarz.DAO

import com.example.kolejarz.model.Recipe

class RecipeDao
{
    var recipeDao = mutableListOf<Recipe>()


    fun insertRecipe(recipe: Recipe)
    {
        recipeDao.add(recipe)
    }


    fun updateRecipe(recipe: Recipe,id: Int)
    {
        recipeDao.elementAt(id)
    }


    fun deleteRecipe(id: Int)
    {
        recipeDao.removeAt(id)
    }

    fun getRecipes(): List<Recipe>
    {
        return recipeDao
    }

    fun getGenders(): List<Recipe>
    {
        return recipeDao
    }

    fun getRecipe(id:Int): Recipe
    {
        return recipeDao.get(id)
    }
}