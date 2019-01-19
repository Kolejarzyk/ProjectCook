package com.example.kolejarz.cook

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.kolejarz.DAO.AppDatabase
import com.example.kolejarz.model.Product
import com.example.kolejarz.model.Recipe
import kotlinx.android.synthetic.main.activity_home_page.*
import java.util.*

class HomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)


        sing_in_button_home_page.setOnClickListener{
            val intent = Intent(this, LoginPage::class.java)
            populateDatabase()
            startActivity(intent)
        }

        register_button_home_page.setOnClickListener{
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
        }
    }


    private fun populateDatabase()
    {
        val product = Product("Papryka","Papryka czerwona","koń",13,"good","none")
        val product1 = Product("Czekolada","Papryka czerwona","koń",13,"good","none")
        val product2 = Product("Kukurydza","Papryka czerwona","koń",13,"good","none")
        val product3 = Product("Udko z kurczaka","Papryka czerwona","koń",13,"good","none")
        AppDatabase.productDao.insertProduct(product)
        AppDatabase.productDao.insertProduct(product1)
        AppDatabase.productDao.insertProduct(product2)
        AppDatabase.productDao.insertProduct(product3)
        val recipe = Recipe(1, "Kucharzenie","coś", mutableListOf(product), Date(2018,9,23),13)
        val recipe1 = Recipe(2, "Kucharzenie1 ","toś", mutableListOf(product), Date(2018,9,23),14)
        val recipe2 = Recipe(3, "Kucharzenie2","poś", mutableListOf(product), Date(2018,9,23),7)
        val recipe3 = Recipe(4, "Kucharzenie3 ","łoś", mutableListOf(product), Date(2018,9,23),78)
        val recipe4 = Recipe(5, "Kucharzenie4","coś", mutableListOf(product), Date(2018,9,23),45)
        val recipe5 = Recipe(6, "Naleśniki","coś", mutableListOf(product), Date(2018,9,23),98)
        AppDatabase.recipeDao.insertRecipe(recipe)
        AppDatabase.recipeDao.insertRecipe(recipe1)
        AppDatabase.recipeDao.insertRecipe(recipe2)
        AppDatabase.recipeDao.insertRecipe(recipe3)
        AppDatabase.recipeDao.insertRecipe(recipe4)
        AppDatabase.recipeDao.insertRecipe(recipe5)
    }
}