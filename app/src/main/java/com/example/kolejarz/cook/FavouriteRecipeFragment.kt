package com.example.kolejarz.cook

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kolejarz.Adapter.RecipeAdapter
import com.example.kolejarz.DAO.AppDatabase
import com.example.kolejarz.model.Recipe
import kotlinx.android.synthetic.main.favourite_recipe_fragment.view.*

/**
 * Class responsible for services and funcionality of FavouriteRecipe fragment.
 */
class FavouriteRecipeFragment : Fragment()
{
    /**
     * LayoutInflater is one of the Android System Services
     * that is responsible for taking your XML files that define a layout,
     * and converting them into View objects.
     * @return A view of the fragment.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.favourite_recipe_fragment,container,false)

        /**
         * Reaches out to database to get all recipes.
         */
        var recipeList : MutableList<Recipe> = AppDatabase.recipeDao.getRecipes()

        /**
         * Connects with Recipe adapter.
         */
        val adapter = RecipeAdapter(this.context,recipeList,this)
        view.recipe_list_view.adapter = adapter

        return view
    }


}