package com.example.kolejarz.Adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kolejarz.DAO.AppDatabase
import com.example.kolejarz.model.Recipe
import kotlinx.android.synthetic.main.row_recipe_item.view.*



class RecipeAdapter(private val context: Context?,private val dataSource: MutableList<Recipe>,private val fragment: Fragment) : BaseAdapter()
{
    private val inflater: LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(com.example.kolejarz.cook.R.layout.row_recipe_item, parent, false)
        val ft = fragment.fragmentManager!!.beginTransaction()

        val recipeName = rowView.recipe_name_item as TextView
        val recipeDescription = rowView.recipe_description_item as TextView
        val favourite = rowView.favourites as TextView
        val recipe = getItem(position) as Recipe

        recipeName.text = recipe.recipe_name
        recipeDescription.text = recipe.user_name
        favourite.text = recipe.like.toString()


        rowView.delete_recipe.setOnClickListener {
            AppDatabase.recipeDao.deleteRecipe(recipe.id-1)

            ft.detach(fragment).attach(fragment).commit()

        }

        rowView.like_recipe.setOnClickListener {
            recipe.like += 1
            AppDatabase.recipeDao.updateRecipe(recipe,recipe.id-1)
            ft.detach(fragment).attach(fragment).commit()
        }
        return rowView
    }
}