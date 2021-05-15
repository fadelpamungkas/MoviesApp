package com.example.moviesapp.repository.localsource

import androidx.lifecycle.LiveData
import androidx.room.*
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

    @Query("select * from movie_favorite")
    fun getAllMovieFromDatabase(): LiveData<List<Movie>>

    @Query("select * from tvshow_favorite")
    fun getAllTVShowFromDatabase(): LiveData<List<TVShow>>

    @Query("select * from movie_favorite where id = :id")
    fun findMovieFromDatabase(id: Int) : LiveData<Movie>

    @Query("select * from tvshow_favorite where id = :id")
    fun findTVShowFromDatabase(id: Int) : LiveData<TVShow>

}