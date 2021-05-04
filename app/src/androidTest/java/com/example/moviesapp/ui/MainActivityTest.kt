package com.example.moviesapp.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.moviesapp.R
import com.example.moviesapp.ui.home.MainActivity
import com.example.moviesapp.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {


    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun loadMovie() {
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rvFragment)).check(matches(isDisplayed()))
        onView(withId(R.id.rvFragment)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                20
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rvFragment)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        0,
                        click()
                )
        )
        onView(withId(R.id.title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.desc_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.rating_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.release_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.runtime_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.image_detail)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTVShow() {
        onView(withText("TVShow")).perform(click())
        onView(withId(R.id.rvFragment)).check(matches(isDisplayed()))
        onView(withId(R.id.rvFragment)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                20
            )
        )
    }

    @Test
    fun loadDetailTVShow() {
        onView(withText("TVShow")).perform(click())
        onView(withId(R.id.rvFragment)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.title_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.desc_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.rating_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.release_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.runtime_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.image_detail)).check(matches(isDisplayed()))
    }

}