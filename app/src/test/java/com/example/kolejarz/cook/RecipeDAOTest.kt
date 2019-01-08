package com.example.kolejarz.cook

import com.example.kolejarz.DAO.RecipeDao
import com.example.kolejarz.model.Recipe
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class RecipeDAOTest {
    var recipes = RecipeDao()

    @Before
    fun Before()
    {
        val recipe1 = Recipe(1, "przepis1", "user1", arrayListOf(1,2,3), Date(2000,1,1))
        val recipe2 = Recipe(2, "przepis2", "user2", arrayListOf(4,5,6), Date(2001,1,1))
        recipes.insertRecipe(recipe1)
        recipes.insertRecipe(recipe2)
    }

    @Test
    fun recipeIdWorking() {
        Assert.assertEquals("id working", 1, recipes.getRecipe(0).id)
    }

    @Test
    fun recipeDaoInsertWorking() {
        val recipe = Recipe(2, "przepis3", "user3", arrayListOf(7,8,9), Date(2001,1,1))
        recipes.insertRecipe(recipe)
        Assert.assertEquals("przepis3", "przepis3", recipes.getRecipe(2).recipe_name)
    }

    @Test
    fun recipeDaoUpdateWorking() {
        val recipe = recipes.getRecipe(0)
        recipe.recipe_name = "przepis2"
        recipes.updateRecipe(recipe, 0)
        Assert.assertEquals("przepis2", "przepis2", recipes.getRecipe(0).recipe_name)
    }

    @Test
    fun recipeDaoDeleteWorking() {
        recipes.deleteRecipe(0)
        Assert.assertEquals("size 1", 1, recipes.getRecipes().size)
        Assert.assertNotEquals("deleted 1st", 0, recipes.getRecipe(0).id)
    }
}