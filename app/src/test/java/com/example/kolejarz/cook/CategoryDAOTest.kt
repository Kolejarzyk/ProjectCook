package com.example.kolejarz.cook

import com.example.kolejarz.DAO.CategoryDao
import com.example.kolejarz.model.Category
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class CategoryDAOTest {
    var categories = CategoryDao()

    @Before
    fun Before(){
        val category1 = Category(1, "kategoria", arrayListOf(1,2,3))
        val category2 = Category(2, "kategoria2", arrayListOf(4,5,6))
        categories.insertCategory(category1)
        categories.insertCategory(category2)
    }
    @Test
    fun categoryIdWorking(){
        assertEquals("id works", 1, categories.getById(0).id)
    }

    @Test
    fun categoryDaoInsertWorking(){
        val category = Category(3, "kategoria3", arrayListOf(7,8,9))
        categories.insertCategory(category)
        assertEquals("insert is kategoria", "kategoria3", categories.getById(2).category_name)
    }

    @Test
    fun categoryDaoUpdateWorking(){
        val category = categories.getById(0)
        category.category_name = "kategoria"
        categories.updateCategory(category, 0)
        assertEquals("kategoria", "kategoria", categories.getById(0).category_name)
    }

    @Test
    fun categoryDaoDeleteWorking() {
        categories.deleteCategory(0)
        assertEquals("size 1", 1, categories.getCategories().size)
        assertNotEquals("1st id deleted", 0, categories.getById(0).id)
    }
}