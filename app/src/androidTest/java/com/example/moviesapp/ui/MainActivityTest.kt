package com.example.moviesapp.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.moviesapp.R
import com.example.moviesapp.ui.home.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTVShow = DataDummy.generateDummyTVShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rvFragment)).check(matches(isDisplayed()))
        onView(withId(R.id.rvFragment)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadTVShow() {
        onView(withText("TVShow")).perform(click())
        onView(withId(R.id.rvFragment)).check(matches(isDisplayed()))
        onView(withId(R.id.rvFragment)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTVShow.size
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
        onView(withId(R.id.title_detail)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.desc_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.desc_detail)).check(matches(withText(dummyMovie[0].description)))
        onView(withId(R.id.genres_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.genres_detail)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.rating_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.rating_detail)).check(matches(withText(dummyMovie[0].rating)))
        onView(withId(R.id.release_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.release_detail)).check(matches(withText(dummyMovie[0].release)))
        onView(withId(R.id.runtime_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.runtime_detail)).check(matches(withText(dummyMovie[0].runtime)))
        onView(withId(R.id.image_detail)).check(matches(isDisplayed()))
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
        onView(withId(R.id.title_detail)).check(matches(withText(dummyTVShow[0].title)))
        onView(withId(R.id.desc_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.desc_detail)).check(matches(withText(dummyTVShow[0].description)))
        onView(withId(R.id.genres_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.genres_detail)).check(matches(withText(dummyTVShow[0].genre)))
        onView(withId(R.id.rating_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.rating_detail)).check(matches(withText(dummyTVShow[0].rating)))
        onView(withId(R.id.release_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.release_detail)).check(matches(withText(dummyTVShow[0].release)))
        onView(withId(R.id.runtime_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.runtime_detail)).check(matches(withText(dummyTVShow[0].runtime)))
        onView(withId(R.id.image_detail)).check(matches(isDisplayed()))
    }

}