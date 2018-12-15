package com.example.kolejarz.cook

import android.content.Context
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sidepanel.*

class SidePanelPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sidepanel)


        // Configure action bar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Hello Toolbar"


        // Initialize the action bar drawer toggle instance
        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        ){
            override fun onDrawerClosed(view: View){
                super.onDrawerClosed(view)
                //toast("Drawer closed")
            }

            override fun onDrawerOpened(drawerView: View){
                super.onDrawerOpened(drawerView)
                //toast("Drawer opened")
            }
        }


        // Configure the drawer layout to add listener and show icon on toolbar
        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()


        // Set navigation view navigation item selected listener
        navigation_view.setNavigationItemSelectedListener{
            when (it.itemId){
                R.id.create_recipe_button_side_panel -> toast("Create Recipe clicked")
                R.id.my_builds_button_side_panel -> toast("My builds clicked")
                R.id.favourites_button_side_panel -> toast("Favourites clicked")
                R.id.products_list_button_side_panel -> toast("Products list clicked")
            }
            // Close the drawer
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }
    }



    // Extension function to show toast message easily
    private fun Context.toast(message:String){
        Toast.makeText(applicationContext,message,Toast.LENGTH_SHORT).show()
    }
}
