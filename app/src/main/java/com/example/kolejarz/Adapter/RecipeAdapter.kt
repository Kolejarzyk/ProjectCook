package com.example.kolejarz.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kolejarz.DAO.AppDatabase
import com.example.kolejarz.cook.R
import com.example.kolejarz.cook.RecipeDetailFragment
import com.example.kolejarz.model.Recipe
import kotlinx.android.synthetic.main.row_recipe_item.view.*

/**
 * An adapter that fill's Product's list with items.
 *
 * @property context grants access to classes from fragments and activities.
 * @property dataSource gets a Product list from correct list.
 * @property fragment pinpoints to the fragment class we will be operating with.
 */
class RecipeAdapter(private val context: Context?,private val dataSource: MutableList<Recipe>,private val fragment: Fragment) : BaseAdapter()
{
    /**
     * LayoutInflater is one of the Android System Services
     * that is responsible for taking your XML files that define a layout,
     * and converting them into View objects.
     */
    private val inflater: LayoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    /**
     * Gets an integer value.
     * @return a size of dataSource's pinpointed list.
     */
    override fun getCount(): Int {
        return dataSource.size
    }

    /**
     * Gets a position of the pinpointed list's item.
     * @return a position of dataSource's pinpointed list.
     */
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    /**
     * Gets item's id.
     * @return change the id type from integer to long.
     */
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    /**
     * Displays the data at the specified position in the data set.
     * @return View of items in readied layout.
     */
    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        /**
         *  Get view for row item
         *  @param row_recipe_item next item on the list to inflate
         *  @param parent parent to match the item with in the layout
         *  @param attachToRoot set to false to preserve expected layout
         */
        val rowView = inflater.inflate(com.example.kolejarz.cook.R.layout.row_recipe_item, parent, false)

        /**
         * Starts manager responsible for setting fragments
         * Sets recipe's parameters as expected view type for layout
         */
        val ft = fragment.fragmentManager!!.beginTransaction()
        val recipeName = rowView.recipe_name_item as TextView
        val recipeDescription = rowView.recipe_description_item as TextView
        val favourite = rowView.favourites as TextView
        val date = rowView.date as TextView

        /**
         * Gets item position and sets it's as the recipe' position
         */
        val recipe = getItem(position) as Recipe

        /**
         * sets value parameters to match actual item value parameters
         */
        recipeName.text = recipe.recipe_name
        recipeDescription.text = recipe.user_name
        favourite.text = recipe.like.toString()
        date.text = recipe.date.day.toString()+"."+recipe.date.month.toString()+"."+recipe.date.year.toString()


        /**
         * This is recipe's listener which deletes a recipe on click.
         */
        rowView.delete_recipe.setOnClickListener {
            AppDatabase.recipeDao.deleteRecipe(recipe.id-1)

            ft.detach(fragment).attach(fragment).commit()

        }

        /**
         * This is recipes's listener which adds 1 to the pool of likes on click.
         */
        rowView.like_recipe.setOnClickListener {
            recipe.like += 1
            AppDatabase.recipeDao.updateRecipe(recipe,recipe.id-1)
            ft.detach(fragment).attach(fragment).commit()
        }

        /**
         * This is recipe's listener which brings up RecipeDetail page.
         */
        rowView.detail_recipe.setOnClickListener {
            val recipeDetail = RecipeDetailFragment()
            val args = Bundle()
            args.putString("recipe_name",recipeName.text.toString())
            recipeDetail.arguments = args

            ft.add(R.id.fragmentContainer,recipeDetail).commit()
        }

        return rowView
    }
}