package com.example.kolejarz.cook


import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.kolejarz.cook.R.id.*
import kotlinx.android.synthetic.main.activity_user_page.*
import kotlinx.android.synthetic.main.toolbar.*


class UserPage : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_page)

        val toolbar = toolbar
        setSupportActionBar(toolbar)

        var drawer = drawer_layout


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId)
        {
            create_recipe_button_side_panel ->
            {
            }
            my_builds_button_side_panel ->
            {

            }
            favourites_button_side_panel ->
            {

            }
            ranking_button_side_panel ->
            {
                val intent = Intent(this, RankingPage::class.java)
                startActivity(intent)
            }
            products_list_button_side_panel ->
            {

            }


        }
        drawer_layout.isDrawerOpen(GravityCompat.START)
        return true
    }





}