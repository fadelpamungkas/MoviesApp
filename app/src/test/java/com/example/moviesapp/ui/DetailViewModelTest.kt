package com.example.moviesapp.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow
import com.example.moviesapp.repository.DataDummy
import com.example.moviesapp.repository.FakeRepository
import com.example.moviesapp.ui.detail.DetailViewModel
import com.example.moviesapp.utils.LiveDataTestUtil
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: FakeRepository

    private val idMovie = 332562
    private val idTVShow = 95557


    @Before
    fun setUp() {
        viewModel = DetailViewModel(repository)
    }


    @Test
    fun setSelectedData() {
        viewModel.setSelectedData(idMovie)
        assertEquals(idMovie, viewModel.id)
    }

    @Test
    fun getSelectedMovie() {
        viewModel.setSelectedData(idMovie)

        val dummyMovie = DataDummy.generateDummyMovies()[0]
        val movies = MutableLiveData<Movie>()
        movies.value = dummyMovie

        Mockito.`when`(repository.getDetailMovie(idMovie)).thenReturn(movies)
        val dataMovie = viewModel.getSelectedMovie().value
        Mockito.verify(repository).getDetailMovie(idMovie)

        assertNotNull(dataMovie)

        assertEquals(dummyMovie.id, dataMovie?.id)
        assertEquals(dummyMovie.title, dataMovie?.title)
        assertEquals(dummyMovie.photo, dataMovie?.photo)
        assertEquals(dummyMovie.rating, dataMovie?.rating)
        assertEquals(dummyMovie.release, dataMovie?.release)
        assertEquals(dummyMovie.runtime, dataMovie?.runtime)
        assertEquals(dummyMovie.description,dataMovie?.description)
    }

    @Test
    fun getSelectedTVShow() {
        viewModel.setSelectedData(idTVShow)

        val dummyTVShow = DataDummy.generateDummyTVShow()[0]
        val tvShow = MutableLiveData<TVShow>()
        tvShow.value = dummyTVShow

        Mockito.`when`(repository.getDetailTV(idTVShow)).thenReturn(tvShow)
        val dataTVShow = viewModel.getSelectedTVShow().value
        Mockito.verify(repository).getDetailTV(idTVShow)

        assertNotNull(dataTVShow)

        assertEquals(dummyTVShow.id, dataTVShow?.id)
        assertEquals(dummyTVShow.title, dataTVShow?.title)
        assertEquals(dummyTVShow.photo, dataTVShow?.photo)
        assertEquals(dummyTVShow.rating, dataTVShow?.rating)
        assertEquals(dummyTVShow.firstAirDate, dataTVShow?.firstAirDate)
        assertEquals(dummyTVShow.episodes, dataTVShow?.episodes)
        assertEquals(dummyTVShow.description,dataTVShow?.description)
    }

}