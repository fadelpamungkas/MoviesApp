package com.example.moviesapp.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow
import com.example.moviesapp.repository.AppRepository
import com.example.moviesapp.ui.home.MainViewModel
import com.example.moviesapp.repository.DataDummy
import com.example.moviesapp.repository.FakeRepository
import com.example.moviesapp.utils.LiveDataTestUtil
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observerMovie: Observer<List<Movie>>
    @Mock
    private lateinit var observerTVShow: Observer<List<TVShow>>

    @Mock
    private lateinit var repository: FakeRepository

    @Before
    fun setUp() {
        viewModel = MainViewModel(repository)
    }

    @Test
    fun getMovies() {
        val dummyMovie = DataDummy.generateDummyMovies()
        val movies = MutableLiveData<List<Movie>>()
        movies.value = dummyMovie

        Mockito.`when`(repository.getPopularMovies()).thenReturn(movies as LiveData<ArrayList<Movie>>)
        val movieEntities = viewModel.getMovie().value
        Mockito.verify(repository).getPopularMovies()
        assertNotNull(movies)
        assertEquals(2, movieEntities?.size)

        viewModel.getMovie().observeForever(observerMovie)
        Mockito.verify(observerMovie).onChanged(dummyMovie)
    }

    @Test
    fun getTVShow() {

        val dummyTVShow = DataDummy.generateDummyTVShow()
        val tvShow = MutableLiveData<List<TVShow>>()
        tvShow.value = dummyTVShow

        Mockito.`when`(repository.getPopularTVs()).thenReturn(tvShow as LiveData<ArrayList<TVShow>>)
        val tvshowEntities = viewModel.getTVShow().value
        Mockito.verify(repository).getPopularTVs()
        assertNotNull(tvShow)
        assertEquals(2, tvshowEntities?.size)

        viewModel.getTVShow().observeForever(observerTVShow)
        Mockito.verify(observerTVShow).onChanged(dummyTVShow)
    }
}