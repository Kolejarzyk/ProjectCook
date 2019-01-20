package com.example.kolejarz.Adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kolejarz.cook.R
import com.example.kolejarz.model.Product
import kotlinx.android.synthetic.main.row_recipe_detail_product_item.view.*

/**
 * An adapter that fill's Recipes list with items.
 *
 * @property context grants access to classes from fragments and activities.
 * @property dataSource gets a Product list from correct list.
 * @property fragment pinpoints to the fragment class we will be operating with.
 */
class ProductRecipeAdapter(private val context: Context?, private val dataSource: MutableList<Product?>, private val fragment: Fragment) : BaseAdapter()
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
    override fun getItem(position: Int): Any? {
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
     * Gets and converts View.
     * @return View of items in readied layout.
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        /**
         *  Get view for row item
         *  @param row_recipe_detail_product_item next item on the list to inflate
         *  @param parent parent to match the item with in the layout
         *  @param attachToRoot set to false to preserve expected layout
         */
        val rowView = inflater.inflate(R.layout.row_recipe_detail_product_item, parent, false)

        /**
         * Sets product's parameter as expected view type for layout
         */
        val productName = rowView.product_name_item as TextView

        /**
         * Gets item position and sets it's as the products' position
         */
        val product = getItem(position) as Product

        /**
         * sets value parameters to match actual item value parameters
         */
        productName.text = product.product_name

        return rowView
    }

}