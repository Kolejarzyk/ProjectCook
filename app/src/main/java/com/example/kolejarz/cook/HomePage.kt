package com.example.kolejarz.cook

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)


        sing_in_button_home_page.setOnClickListener{
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }

        register_button_home_page.setOnClickListener{
            val intent = Intent(this, RegisterPage::class.java)
            startActivity(intent)
        }
    }

}