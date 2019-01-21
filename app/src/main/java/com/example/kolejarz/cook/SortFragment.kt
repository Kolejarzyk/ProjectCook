package com.example.kolejarz.cook

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kolejarz.Adapter.RecipeAdapter
import com.example.kolejarz.DAO.AppDatabase
import com.example.kolejarz.model.Recipe
import kotlinx.android.synthetic.main.activity_sort_page.view.*

/**
 * Class responsible for Ranking page's fragment.
 */
class SortFragment : Fragment() {

    var recipes = AppDatabase.recipeDao.getRecipes()
    /**
     * LayoutInflater is one of the Android System Services
     * that is responsible for taking your XML files that define a layout,
     * and converting them into View objects.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_sort_page,null)

        view.sort_name_button.setOnClickListener {
            recipes = recipes.sortedBy { recipe -> recipe.recipe_name } as MutableList<Recipe>
            fragmentManager?.beginTransaction()?.detach(this)?.attach(this)?.commit()
        }

        view.sort_like_button.setOnClickListener {
            recipes = recipes.sortedBy { recipe -> recipe.like } as  MutableList<Recipe>
            fragmentManager?.beginTransaction()?.detach(this)?.attach(this)?.commit()
        }

        val adapter = RecipeAdapter(this.context, recipes,this)

        view.recipe_list_view.adapter = adapter

        return view
    }


    }
