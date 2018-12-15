package com.example.kolejarz.cook


import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_user_page.*
import kotlinx.android.synthetic.main.toolbar.*

class UserPage : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_page)

        val toolbar = toolbar
        setSupportActionBar(toolbar)



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            android.R.id.home ->
               if(drawer_layout.isDrawerOpen(GravityCompat.START))
               return true

        }
        return super.onOptionsItemSelected(item)
    }
}