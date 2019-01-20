package com.example.kolejarz.cook

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.kolejarz.DAO.AppDatabase
import com.example.kolejarz.model.Product
import com.example.kolejarz.model.Recipe
import kotlinx.android.synthetic.main.activity_recipe_builder.view.*
import java.util.*

/**
 * Class responsible for services and funcionality of CreateRecipe page.
 */
class CreateRecipePage : Fragment()
{

    /**
     * LayoutInflater is one of the Android System Services
     * that is responsible for taking your XML files that define a layout,
     * and converting them into View objects.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View =  inflater.inflate(R.layout.activity_recipe_builder,null)
        val products : MutableList<Product?> = mutableListOf()

        /**
         * This is recipe's listener which adds a recipe on click
         * and adds it to the application's database.
         */
        view.addRecipeButton.setOnClickListener{
            val recipe = Recipe(2,view.nameRecipe.text.toString(),"recipe_product", products, Date(1995,5,23),0)
            AppDatabase.recipeDao.insertRecipe(recipe)
        }

        /**
         * This is product's listener which adds a product on click,
         * @return and shows it in the layout.
         */
        view.addProductButton.setOnClickListener{

        }
        addProduct(view,products)
        showProducts(view,products)
        return view
    }


    /**
     * Responsible for showing list of products.
     */
    private fun  showProducts(view: View,products: MutableList<Product?>)
    {
        /**
         * Iterates over products and add each's name to the textView
         */
        products.forEach {
            val textView = TextView(this.context)
            textView.text = it?.product_name
            view.recipeBuilderView.addView(textView)
        }
    }

    /**
     * Responsible for adding items to application's database.
     */
    private fun addProduct(view: View,products: MutableList<Product?>)
    {
        /**
         * This is product's listener which adds a product to the database on click.
         */
       view.addProductButton.setOnClickListener {
            products.add(AppDatabase.productDao.getByProductName(view.product_name.text.toString()))

       }
    }
}

