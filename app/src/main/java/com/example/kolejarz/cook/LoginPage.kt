package com.example.kolejarz.cook

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.util.Patterns
import kotlinx.android.synthetic.main.activity_login_page.*


class LoginPage : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)


    login_button_login.setOnClickListener{

        if(isValidEmail(email_textField_login.text))
        {
            if(isPasswordValid(password_textField_login.text))
            {
                login_button_login.setOnClickListener{
                    val intent = Intent(this, UserPage::class.java)
                    startActivity(intent) }
            }
            else
            {
                error_password.text = "Pass is bad"
                error_password.setTextColor(Color.parseColor("#FF0000"))
            }
        }
        else{
            error_email.text = "Erro is bad man"
            error_email.setTextColor(Color.parseColor("#FF0000"))
        }

    }
}


    companion object {
        fun isValidEmail(target: CharSequence): Boolean
        {
            if(TextUtils.isEmpty(target))
                return false
            else
                return Patterns.EMAIL_ADDRESS.matcher(target).matches()

        }

        fun isPasswordValid(target:CharSequence): Boolean
        {
            return !TextUtils.isEmpty(target)
        }
    }
}