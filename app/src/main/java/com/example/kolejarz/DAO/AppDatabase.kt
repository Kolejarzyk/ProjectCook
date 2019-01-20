package com.example.kolejarz.DAO

/**
 * Application's database.
 */
class AppDatabase
{
    companion object {
        val recipeDao = RecipeDao()
        val productDao = ProductDao()
        val categoryDao = CategoryDao()
    }
}