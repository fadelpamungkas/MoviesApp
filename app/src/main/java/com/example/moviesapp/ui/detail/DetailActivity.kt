package com.example.moviesapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityDetailBinding
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
        const val EXTRA_MOVIE = 100
        const val EXTRA_TVSHOW = 101
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        if (intent.extras != null) {
            val id = intent.getIntExtra(EXTRA_ID, 0)
            val type = intent.getIntExtra(EXTRA_TYPE, 0)

            viewModel.setSelectedData(id)
            when (type) {
                EXTRA_MOVIE -> {
                    viewModel.getSelectedMovie().observe(this, { movie ->
                        bindView(movie)
                    })
                }
                EXTRA_TVSHOW -> {
                    viewModel.getSelectedTVShow().observe(this, { tvShow ->
                        bindView(tvShow)
                    })
                }
                else -> return
            }
        }

    }

    private fun bindView(movie: Movie) {
        with(binding) {
            titleDetail.text = movie.title
            rating.text = getString(R.string.rating)
            ratingDetail.text = movie.rating.toString()
            release.text = getString(R.string.release_date)
            releaseDetail.text = movie.release
            runtime.text = getString(R.string.runtime)
            runtimeDetail.text = getString(R.string.minutes_ext, movie.runtime.toString())
            descDetail.text = movie.description
            Glide.with(this@DetailActivity)
                .load("https://image.tmdb.org/t/p/w185" + movie.photo)
                .into(imageDetail)
        }
    }

    private fun bindView(tvShow: TVShow) {
        with(binding) {
            titleDetail.text = tvShow.title
            rating.text = getString(R.string.rating)
            ratingDetail.text = tvShow.rating.toString()
            release.text = getString(R.string.first_air_date)
            releaseDetail.text = tvShow.firstAirDate
            runtime.text = getString(R.string.episodes)
            runtimeDetail.text = getString(R.string.episodes_ext, tvShow.episodes.toString())
            descDetail.text = tvShow.description
            Glide.with(this@DetailActivity)
                .load("https://image.tmdb.org/t/p/w185" + tvShow.photo)
                .into(imageDetail)
        }
    }
}