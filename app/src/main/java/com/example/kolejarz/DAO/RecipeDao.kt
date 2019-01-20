package com.example.kolejarz.DAO

import com.example.kolejarz.model.Recipe

/**
 * Data Access Object of Recipe.
 */
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

    fun getRecipes(): MutableList<Recipe>
    {
        return recipeDao
    }

    fun getRecipe(id:Int): Recipe
    {
        return recipeDao.get(id)
    }

    fun getRecipeByName(name : String) : Recipe?
    {
        return recipeDao.find { recipe -> recipe.recipe_name == name }
    }
}