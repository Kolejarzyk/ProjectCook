package com.example.kolejarz.cook

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.scrollTo
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ActivityButtonTest {

    @Test
    fun testingTest() {
        onView(withText("Hello world!")).check(matches(isDisplayed()))
    }

    @Test
    fun activityHomePageButtonSignIn() {
        onView(withId(R.id.sing_in_button_home_page))
            .perform(click())
            .check(matches(isDisplayed()))
    }

    @Test
    fun activityHomePageButtonLogIn() {
        onView(withId(R.id.register_button_home_page))
            .perform(click())
            .check(matches(isDisplayed()))
    }

    @Test
    fun activityLoginPageButtonLogin() {
        onView(withId(R.id.login_button_login))
            .perform(click())
            .check(matches(isDisplayed()))
    }

    @Test
    fun activityRankingPageButtonRecipe() {
        onView(withId(R.id.recipeButton))
            .perform(click())
            .check(matches(isDisplayed()))
    }

    @Test
    fun activityRecipeBuilderPageButtonAddProduct() {
        onView(withId(R.id.addProductButton))
            .perform(scrollTo(), click())
            .check(matches(isDisplayed()))
    }

    @Test
    fun activityRecipeBuilderPageButtonAddRecipe() {
        onView(withId(R.id.addProductButton))
            .perform(scrollTo(), click())
            .check(matches(isDisplayed()))
    }

    @Test
    fun activityRegisterPageButtonRegister() {
        onView(withId(R.id.register_button_register))
            .perform(click())
            .check(matches(isDisplayed()))
    }

    @Test
    fun rowProductButton1() {
        onView(withId(R.id.button1))
            .perform(scrollTo(), click())
            .check(matches(isDisplayed()))
    }

    @Test
    fun rowRecipeDelete() {
        onView(withId(R.id.delete_recipe))
            .perform(scrollTo(), click())
            .check(matches(isDisplayed()))
    }

    @Test
    fun rowRecipeLike() {
        onView(withId(R.id.like_recipe))
            .perform(click())
            .check(matches(withText("@string/number_of_views"+1)))
            //.check(matches(withText("290"))) na wypadek jakby to +1 jednak nie dzialalo
    }
}