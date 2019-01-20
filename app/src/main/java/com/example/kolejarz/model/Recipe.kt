package com.example.kolejarz.model

import java.util.*

/**
 * A model for DAO's Recipe
 */
class Recipe ( var id : Int, var recipe_name: String, var user_name: String,var description: String, var product: MutableList<Product?>, var date: Date,var like: Int)