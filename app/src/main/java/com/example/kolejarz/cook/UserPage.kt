package com.example.kolejarz.cook


import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.kolejarz.cook.R.id.*
import com.example.kolejarz.cook.R.menu.drawer_view
import kotlinx.android.synthetic.main.activity_user_page.*
import kotlinx.android.synthetic.main.toolbar.*
import java.lang.ClassCastException


class UserPage : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_page)
        navigation_View.setNavigationItemSelectedListener{
            selectDrawItem(it)
            true
        }
    }

    private fun selectDrawItem(item: MenuItem)
    {
        var fragment : Fragment? = null
        val fragmentClass = when(item.itemId){

            R.id.create_recipe_button_side_panel -> CreateRecipePage::class.java
            R.id.favourites_button_side_panel ->  FavouriteRecipeFragment::class.java
            R.id.ranking_button_side_panel -> RankingPage::class.java
            R.id.products_list_button_side_panel -> ProductListPage::class.java
            else ->{
                ProductListPage::class.java
            }
        }
        try {
            fragment = fragmentClass.newInstance() as Fragment
        }
        catch (e: ClassCastException)
        {
            e.printStackTrace()
        }
        replaceFragment(fragment)
        drawer_layout.closeDrawer(GravityCompat.START)
    }

    private fun replaceFragment(fragment: Fragment?)
    {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (fragment != null) {
            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        }
        fragmentTransaction.commit()
    }

}