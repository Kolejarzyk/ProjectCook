package com.example.kolejarz.cook

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kolejarz.DAO.AppDatabase
import kotlinx.android.synthetic.main.activity_product_page.view.*

/**
 * Class responsible for Product's list fragment.
 */
class ProductFragment : Fragment() {

    /**
     * LayoutInflater is one of the Android System Services
     * that is responsible for taking your XML files that define a layout,
     * and converting them into View objects.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.activity_product_page, container, false)

        /**
         * Sets String for value.
         */
        val value = arguments?.getString("product_name").toString()

        /**
         * Gets product's names from database.
         */
        val currentProduct = AppDatabase.productDao.getByProductName(value)

        /**
         * Set product's names for view.
         */
        view.product_name.text = currentProduct?.product_name
        view.description.text = currentProduct?.description
        view.cal_number.text = currentProduct?.calories.toString()
        view.nutrition.text = currentProduct?.nutrients
        view.allergic.text = currentProduct?.alergies
        view.imageView.setImageResource(currentProduct?.img!!)
        return view
    }
}