package com.example.kolejarz.cook

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewAction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v4.app.Fragment
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityButtonTest {

    @Rule
    @JvmField
    val rule: ActivityTestRule<HomePage> = ActivityTestRule(HomePage::class.java)

    @Before
    fun init() {
        rule.activity
            .supportFragmentManager.beginTransaction()
    }

    @Before
    fun sign_in()
    {
        onView((withId(R.id.sing_in_button_home_page)))
            .perform(click())
    }


    @Test
    fun login_email_failed(){

        onView((withId(R.id.login_button_login))
        ).perform(click())

        onView((withId(R.id.error_email))).check(matches(withText("Email is incorrect")))
    }

    @Test
    fun login_password_failed(){
        onView((withId(R.id.email_textField_login))).perform(ViewActions.typeText("pawel.dee@gmail.com"), closeSoftKeyboard())
        onView((withId(R.id.login_button_login))).perform(click())

        onView((withId(R.id.error_password))).check(matches(withText("Password is incorrect")))
    }


    @Test
    fun loginSuccessful() {


        onView((withId(R.id.email_textField_login))).perform(ViewActions.typeText("pawel.dee@gmail.com"))
        onView((withId(R.id.password_textField_login))).perform(ViewActions.typeText("cokolwiek"), closeSoftKeyboard())
        onView((withId(R.id.login_button_login))).perform(click())
        val defaultFragment = ProductListFragment::class.java
        val fragment = defaultFragment.newInstance() as Fragment

        rule.activity.supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
        onView((withId(R.id.textView12))).check(matches(withText(R.id.productList)))
    }
}