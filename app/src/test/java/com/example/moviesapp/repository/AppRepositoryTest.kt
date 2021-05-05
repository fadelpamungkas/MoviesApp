package com.example.moviesapp.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.moviesapp.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class AppRepositoryTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(FakeRemoteData::class.java)
    private val repository = FakeRepository(remote)

    private val moviesResponses = DataDummy.generateDummyMovies()
    private val movieContent = moviesResponses[0]
    private val tvshowResponses = DataDummy.generateDummyTVShow()
    private val tvshowContent = tvshowResponses[0]

    @Test
    fun getPopularMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as FakeRemoteData.LoadMoviesCallback)
                .onAllMoviesReceived(moviesResponses)
            null
        }.`when`(remote).getPopularMovies(any())
        val moviesEntities = LiveDataTestUtil.getValue(repository.getPopularMovies())
        verify(remote).getPopularMovies(any())
        Assert.assertNotNull(moviesEntities)
        assertEquals(moviesResponses.size.toLong(), moviesEntities.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[1] as FakeRemoteData.LoadMovieContentCallback)
                .onContentReceived(movieContent)
            null
        }.`when`(remote).getMovieContent(eq(movieContent.id), any())

        val movieEntitiesContent = LiveDataTestUtil.getValue(repository.getDetailMovie(movieContent.id))

        verify(remote)
            .getMovieContent(eq(movieContent.id), any())

        Assert.assertNotNull(movieEntitiesContent)
        assertEquals(movieContent.id, movieEntitiesContent.id)
    }

    @Test
    fun getPopularTVs() {
        doAnswer { invocation ->
            (invocation.arguments[0] as FakeRemoteData.LoadTVShowCallback)
                .onAllTVShowReceived(tvshowResponses)
            null
        }.`when`(remote).getPopularTVShow(any())
        val tvshowEntities = LiveDataTestUtil.getValue(repository.getPopularTVs())
        verify(remote).getPopularTVShow(any())
        Assert.assertNotNull(tvshowEntities)
        assertEquals(tvshowResponses.size.toLong(), tvshowEntities.size.toLong())
    }

    @Test
    fun getDetailTV() {
        doAnswer { invocation ->
            (invocation.arguments[1] as FakeRemoteData.LoadTVContentCallback)
                .onContentReceived(tvshowContent)
            null
        }.`when`(remote).getTVContent(eq(tvshowContent.id), any())

        val tvshowEntitiesContent = LiveDataTestUtil.getValue(repository.getDetailTV(tvshowContent.id))

        verify(remote)
            .getTVContent(eq(tvshowContent.id), any())

        Assert.assertNotNull(tvshowEntitiesContent)
        assertEquals(tvshowContent.id, tvshowEntitiesContent.id)
    }
}