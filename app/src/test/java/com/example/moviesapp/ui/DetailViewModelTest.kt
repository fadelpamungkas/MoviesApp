package com.example.moviesapp.ui

import com.example.moviesapp.utils.DataDummy
import junit.framework.TestCase

class DetailViewModelTest : TestCase() {
    private lateinit var viewModel: DetailViewModel
    private val dummyData = DataDummy.generateDummyMovies()[0]
    private val id = dummyData.id

    public override fun setUp() {
        super.setUp()
        viewModel = DetailViewModel()
        viewModel.setSelectedData(id)
    }

    fun testSetSelectedCourse() {}

    fun testGetData() {
        viewModel.setSelectedData(dummyData.id)
        val data = viewModel.getData()
        assertNotNull(data)
        if (data != null) {
            assertEquals(dummyData.id, data.id)
            assertEquals(dummyData.title, data.title)
            assertEquals(dummyData.description, data.description)
            assertEquals(dummyData.genre, data.genre)
            assertEquals(dummyData.photo, data.photo)
            assertEquals(dummyData.rating, data.rating)
            assertEquals(dummyData.release, data.release)
            assertEquals(dummyData.runtime, data.runtime)
        }
    }
}