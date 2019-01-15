package com.example.kolejarz.DAO

import com.example.kolejarz.model.Category

class CategoryDao
{
   var categoryDao = mutableListOf<Category>()

    fun insertCategory(recipe: Category)
    {
        categoryDao.add(recipe)
    }


    fun updateCategory(category: Category,id: Int)
    {
        categoryDao.set(id,category)
    }


    fun deleteCategory(id: Int)
    {
        categoryDao.removeAt(id)
    }

    fun getCategories(): List<Category>
    {
        return categoryDao
    }

    fun getById(id: Int) : Category
    {
        return categoryDao.get(id)
    }
}