package com.example.moviesapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.moviesapp.databinding.ActivityDetailBinding
import com.example.moviesapp.model.Movie

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        if (intent.extras != null) {
            val id = intent.getIntExtra(EXTRA_MOVIE, 0)
            viewModel.setSelectedCourse(id)
            val movie = viewModel.getCourse()
            if (movie != null) {
                bindView(movie)
            }
        }

    }

    private fun bindView(movie: Movie) {
        with(binding) {
            titleDetail.text = movie.title
            ratingDetail.text = movie.rating
            releaseDetail.text = movie.release
            runtimeDetail.text = movie.runtime
            genresDetail.text = movie.genre
            descDetail.text = movie.description
            imageDetail.setImageResource(movie.photo)
        }
    }
}