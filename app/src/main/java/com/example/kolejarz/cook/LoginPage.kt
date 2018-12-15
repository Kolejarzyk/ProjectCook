package com.example.kolejarz.cook

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login_page.*


class LoginPage : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        login_button_login.setOnClickListener{
            val intent = Intent(this, UserPage::class.java)
            startActivity(intent)

    }


}
}