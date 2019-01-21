package com.example.kolejarz.cook

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v4.app.Fragment
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class UserPageTest {

    @Rule
    @JvmField
    val rule: ActivityTestRule<UserPage> = ActivityTestRule(UserPage::class.java)

    @Before
    fun init() {
        val defaultFragment = ProductListFragment::class.java
        val fragment = defaultFragment.newInstance() as Fragment

        rule.activity
            .supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment)
    }


    @Test
    fun CheckProductListText() {

        onView((ViewMatchers.withId(R.id.textView12)))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.id.product_name_item)))
    }
}