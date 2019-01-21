package com.example.kolejarz.cook

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kolejarz.Adapter.ProductAdapter
import com.example.kolejarz.DAO.AppDatabase
import com.example.kolejarz.model.Product
import com.example.kolejarz.model.Recipe
import kotlinx.android.synthetic.main.activity_recipe_builder.view.*
import java.util.*

/**
 * Class responsible for services and funcionality of CreateRecipe page.
 */
class CreateRecipeFragment : Fragment()
{
    var products : MutableList<Product> = mutableListOf()
    /**
     * LayoutInflater is one of the Android System Services
     * that is responsible for taking your XML files that define a layout,
     * and converting them into View objects.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View =  inflater.inflate(R.layout.activity_recipe_builder,null)
        val date = Date(Calendar.DAY_OF_MONTH,Calendar.MONTH,Calendar.YEAR)
        /**
         * This is recipe's listener which adds a recipe on click
         * and adds it to the application's database.
         */
        view.addRecipeButton.setOnClickListener{
            val recipe = Recipe(6,view.nameRecipe.text.toString(),"",view.create_recipe_description.text.toString(),
                products.toMutableList(), date,0)
            AppDatabase.recipeDao.insertRecipe(recipe)
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainer,FavouriteRecipeFragment::class.java.newInstance())?.commit()
        }

        /**
         * This is product's listener which adds a product on click,
         * @return and shows it in the layout.
         */
        view.addProductButton.setOnClickListener{
            products.add(AppDatabase.productDao.getByProductName(view.product_name.text.toString())!!)
            fragmentManager?.beginTransaction()?.detach(this)?.attach(this)?.commit()
        }

        val adapter = ProductAdapter(this.context, products,this)

        view.create_recipe_products.adapter = adapter
        return view
    }




}

