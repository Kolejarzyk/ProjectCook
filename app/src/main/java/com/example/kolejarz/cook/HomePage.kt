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
        val product = Product("Apple","Sweet Bee apple","An apple is a sweet, edible fruit produced by an apple tree (Malus pumila).",52,"Vitamin E, C, K","none")
        val product1 = Product("Cucumber"," Armenian cucumber","Cucumber (Cucumis sativus) is a widely cultivated plant in the gourd family, Cucurbitaceae.",67,"Vitamin C, K","none")
        val product2 = Product("Salt","Kosher Salt or Kitchen Salt","Kitchen salt is coarse edible salt without common additives such as iodine.",0,"Mineral Calcium","in high doses")
        val product3 = Product("Orange","Mandarian Orange","The orange is the fruit of the citrus species Citrus × sinensis in the family Rutaceae.",47,"Vitamin B1, B2, B3","none")
        AppDatabase.productDao.insertProduct(product)
        AppDatabase.productDao.insertProduct(product1)
        AppDatabase.productDao.insertProduct(product2)
        AppDatabase.productDao.insertProduct(product3)
        val recipe = Recipe(1, "My recipe","Best_Cook", mutableListOf(product), Date(2018,9,21),13)
        val recipe1 = Recipe(2, "Sphagetti","SphagettiMonster", mutableListOf(product), Date(2018,1,23),14)
        val recipe2 = Recipe(3, "Roasted Chicken","Chicken_Lord", mutableListOf(product), Date(2018,8,13),7)
        val recipe3 = Recipe(4, "Pancakes","Pancracy", mutableListOf(product), Date(2018,6,23),78)
        val recipe4 = Recipe(5, "Eggplant","Bland_User", mutableListOf(product), Date(2018,5,23),45)
        val recipe5 = Recipe(6, "Fish soup","Sam_Fisher", mutableListOf(product), Date(2019,1,1),98)
        AppDatabase.recipeDao.insertRecipe(recipe)
        AppDatabase.recipeDao.insertRecipe(recipe1)
        AppDatabase.recipeDao.insertRecipe(recipe2)
        AppDatabase.recipeDao.insertRecipe(recipe3)
        AppDatabase.recipeDao.insertRecipe(recipe4)
        AppDatabase.recipeDao.insertRecipe(recipe5)
    }
}