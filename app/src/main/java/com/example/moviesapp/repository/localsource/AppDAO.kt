package com.example.moviesapp.repository.localsource

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow

@Dao
interface AppDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: Movie)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tvShow: TVShow)

    @Query("delete from movie_favorite where id = :id")
    suspend fun deleteMovie(id: Int)

    @Query("delete from tvshow_favorite where id = :id")
    suspend fun deleteTVShow(id : Int)

//    @Query("select * from movie_favorite")
    @RawQuery(observedEntities = [Movie::class])
    fun getAllMovieFromDatabase(query: SimpleSQLiteQuery): DataSource.Factory<Int, Movie>

//    @Query("select * from tvshow_favorite")
    @RawQuery(observedEntities = [TVShow::class])
    fun getAllTVShowFromDatabase(query: SimpleSQLiteQuery): DataSource.Factory<Int, TVShow>

    @Query("select * from movie_favorite where id = :id")
    fun findMovieFromDatabase(id: Int) : LiveData<Movie>

    @Query("select * from tvshow_favorite where id = :id")
    fun findTVShowFromDatabase(id: Int) : LiveData<TVShow>

}