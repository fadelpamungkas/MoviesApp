package com.example.moviesapp.ui.detail

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.databinding.ActivityDetailBinding
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var bookmarkStatus = false

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

        val detailViewModel: DetailViewModel by viewModels()

        var id: Int = 0
        var type: Int = 0
        var movieData: Movie = Movie(id)
        var tvShowData: TVShow = TVShow(id)

        if (intent.extras != null) {
            id = intent.getIntExtra(EXTRA_ID, 0)
            type = intent.getIntExtra(EXTRA_TYPE, 0)

            binding.progressbar.visibility = View.VISIBLE

            when (type) {
                EXTRA_MOVIE -> {
                    detailViewModel.findMovie(id)?.observe(this, { movie ->
                        if (movie != null){
                            movieData = movie
                            bindView(movie)
                            bookmarkStatus = true
                            fabBookmarkIcon(true)
                        } else {
                            detailViewModel.setSelectedMovie(id)
                            detailViewModel.getSelectedMovie().observe(this, { movie ->
                                movieData = movie
                                bindView(movie)
                                fabBookmarkIcon(false)
                            })
                        }

                    })
                }
                EXTRA_TVSHOW -> {
                    detailViewModel.findTVShow(id)?.observe(this, { tvShow ->
                        if (tvShow != null){
                            tvShowData = tvShow
                            bindView(tvShow)
                            bookmarkStatus = true
                            fabBookmarkIcon(true)
                        } else {
                            detailViewModel.setSelectedTV(id)
                            detailViewModel.getSelectedTVShow().observe(this, { tvShow ->
                                tvShowData = tvShow
                                bindView(tvShow)
                                fabBookmarkIcon(false)
                            })
                        }

                    })
                }
                else -> return
            }
        }

        binding.fabFavorite.setOnClickListener { view ->
            if (!bookmarkStatus) {
                when (type) {
                    EXTRA_MOVIE -> detailViewModel.insert(movieData)
                    EXTRA_TVSHOW -> detailViewModel.insert(tvShowData)
                    else -> return@setOnClickListener
                }
                fabBookmarkIcon(true)
                Snackbar.make(view, getString(R.string.add_to_bookmark), Snackbar.LENGTH_SHORT).show()
            } else {
                when (type) {
                    EXTRA_MOVIE -> detailViewModel.deleteMovie(movieData.id)
                    EXTRA_TVSHOW -> detailViewModel.deleteTVShow(tvShowData.id)
                    else -> return@setOnClickListener
                }
                fabBookmarkIcon(false)
                Snackbar.make(view, getString(R.string.remove_from_bookmark), Snackbar.LENGTH_SHORT).show()
            }
            bookmarkStatus = !bookmarkStatus
        }

    }

    private fun fabBookmarkIcon(bookmark: Boolean) {
        if (bookmark) {
            binding.fabFavorite.setImageResource(R.drawable.ic_bookmark_24)
        } else {
            binding.fabFavorite.setImageResource(R.drawable.ic_bookmark_border_24)
        }
    }

    private fun bindView(movie: Movie) {
        with(binding) {
            progressbar.visibility = View.GONE

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
            progressbar.visibility = View.GONE

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