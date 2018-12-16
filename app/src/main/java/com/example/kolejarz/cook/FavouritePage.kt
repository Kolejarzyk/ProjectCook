package com.example.kolejarz.cook

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

class FavouritePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.favourites_page)

        val fragment = FavouriteRecipeFragment.newInstance()
        replacmentFragment(fragment)
    }

    private fun replacmentFragment(fragment: Fragment)
    {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }
}