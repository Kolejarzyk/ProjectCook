package com.example.kolejarz.DAO

class AppDatabase
{
    companion object {
        val recipeDao = RecipeDao()
        val productDao = ProductDao()
        val categoryDao = CategoryDao()
    }
}