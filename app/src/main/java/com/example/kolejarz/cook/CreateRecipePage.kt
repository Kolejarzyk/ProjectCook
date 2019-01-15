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


class CreateRecipePage : Fragment()
{

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View =  inflater.inflate(R.layout.activity_recipe_builder,null)
        val products : MutableList<Product?> = mutableListOf()
        view.addRecipeButton.setOnClickListener{
            val recipe = Recipe(2,view.nameRecipe.text.toString(),"recipe_product", products, Date(1995,5,23),0)
            AppDatabase.recipeDao.insertRecipe(recipe)
        }

        view.addProductButton.setOnClickListener{

        }
        addProduct(view,products)
        showProducts(view,products)
        return view
    }


    private fun  showProducts(view: View,products: MutableList<Product?>)
    {
        products.forEach {
            val textView = TextView(this.context)
            textView.text = it?.product_name
            view.recipeBuilderView.addView(textView)
        }
    }

    private fun addProduct(view: View,products: MutableList<Product?>)
    {
       view.addProductButton.setOnClickListener {
            products.add(AppDatabase.productDao.getByProductName(view.product_name.text.toString()))

       }
    }
}

