package com.example.kolejarz.cook

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.kolejarz.cook.R.id.*
import com.example.kolejarz.cook.R.layout.activity_user_page
import kotlinx.android.synthetic.main.activity_user_page.*
import java.lang.ClassCastException

/**
 * Class responsible for services and funcionality of User page.
 */
class UserPage : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_user_page)

        /**
         * Sets Listener for navigation drawer.
         */
        navigation_View.setNavigationItemSelectedListener{
            selectDrawItem(it)
            true
        }
    }

    /**
     * Chooses a fragment to display.
     * Creates a new instance of that fragment and passes it to fragment manager.
     */
    private fun selectDrawItem(item: MenuItem)
    {
        var fragment : Fragment? = null
        val fragmentClass = when(item.itemId){

            create_recipe_button_side_panel -> CreateRecipePage::class.java
            my_builds_button_side_panel ->  FavouriteRecipeFragment::class.java
            ranking_button_side_panel -> RankingPage::class.java
            products_list_button_side_panel -> ProductListPage::class.java
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

    /**
     * Replaces actual fragment for the one we want to display.
     */
    private fun replaceFragment(fragment: Fragment?)
    {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (fragment != null) {
            fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        }
        fragmentTransaction.commit()
    }

}