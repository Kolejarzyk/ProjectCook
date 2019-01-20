package com.example.kolejarz.cook

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kolejarz.Adapter.ProductRecipeAdapter
import com.example.kolejarz.DAO.AppDatabase
import kotlinx.android.synthetic.main.fragment_recipe_details.view.*

/**
 * Class responsible for Recipe Detail's fragment.
 */
class RecipeDetailFragment : Fragment()
{
    /**
     * LayoutInflater is one of the Android System Services
     * that is responsible for taking your XML files that define a layout,
     * and converting them into View objects.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.fragment_recipe_details,container,false)

        /**
         * Sets String for value.
         */
        val value = arguments?.getString("recipe_name").toString()

        /**
         * Gets Recipes from database.
         */
        val currentRecipe = AppDatabase.recipeDao.getRecipeByName(value)

        /**
         * sets value parameter to match actual item value parameter.
         */
        view.nameRecipe.text = currentRecipe?.recipe_name

        val adapter = ProductRecipeAdapter(this.context, currentRecipe!!.product,this)
        view.product_list_recipe.adapter = adapter

        return view
    }
}