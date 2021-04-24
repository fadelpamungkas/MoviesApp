package com.example.moviesapp.ui

import junit.framework.TestCase

class MainViewModelTest : TestCase() {
    private lateinit var viewModel: MainViewModel

    override fun setUp() {
        viewModel = MainViewModel()
    }

    fun testGetMovies() {
        val dataMovie = viewModel.getMovies()
        assertNotNull(dataMovie)
        assertEquals(10, dataMovie.size)
    }


    fun testGetTVShow() {
        val dataTV = viewModel.getTVShow()
        assertNotNull(dataTV)
        assertEquals(10, dataTV.size)
    }
}