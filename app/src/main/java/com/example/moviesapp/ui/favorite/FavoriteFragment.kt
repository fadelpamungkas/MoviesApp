package com.example.moviesapp.ui.favorite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.adapter.MovieAdapter
import com.example.moviesapp.adapter.MoviePagingAdapter
import com.example.moviesapp.adapter.TVShowAdapter
import com.example.moviesapp.adapter.TVShowPagingAdapter
import com.example.moviesapp.databinding.FragmentFavoriteBinding
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow
import com.example.moviesapp.ui.detail.DetailActivity
import com.example.moviesapp.utils.SortUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {
    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        @JvmStatic
        fun newInstance(index: Int) =
            FavoriteFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, index)
                }
            }
    }

    private lateinit var binding: FragmentFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by activityViewModels()
    private val movieAdapter = MoviePagingAdapter()
    private val tvShowAdapter = TVShowPagingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFavoriteBinding.bind(view)
        binding.rvFragment.layoutManager = LinearLayoutManager(this.context)
        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)


        when (index) {
            1 -> {
                movieAdapter.notifyDataSetChanged()
                binding.rvFragment.adapter = movieAdapter
                binding.progressbar.visibility = View.VISIBLE

                observeData(SortUtils.TYPE_MOVIE, SortUtils.TITLE)

                movieAdapter.setOnItemClickCallback(object : MoviePagingAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: Movie) {
                        val intent = Intent(activity, DetailActivity::class.java)
                        intent.putExtra(DetailActivity.EXTRA_ID, data.id)
                        intent.putExtra(DetailActivity.EXTRA_TYPE, DetailActivity.EXTRA_MOVIE)
                        startActivity(intent)
                    }

                })
            }

            2 -> {
                tvShowAdapter.notifyDataSetChanged()
                binding.rvFragment.adapter = tvShowAdapter
                binding.progressbar.visibility = View.VISIBLE

                observeData(SortUtils.TYPE_TVSHOW, SortUtils.TITLE)

                tvShowAdapter.setOnItemClickCallback(object : TVShowPagingAdapter.OnItemClickCallback {

                    override fun onItemClicked(data: TVShow) {
                        val intent = Intent(activity, DetailActivity::class.java)
                        intent.putExtra(DetailActivity.EXTRA_ID, data.id)
                        intent.putExtra(DetailActivity.EXTRA_TYPE, DetailActivity.EXTRA_TVSHOW)
                        startActivity(intent)
                    }

                })
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var sort = ""
        when (item.itemId) {
            R.id.action_title_asc -> sort = SortUtils.TITLE
            R.id.action_top_rating -> sort = SortUtils.TOP_RATING
            R.id.action_random -> sort = SortUtils.RANDOM
        }
        observeData(SortUtils.TYPE_MOVIE, sort)
        observeData(SortUtils.TYPE_TVSHOW, sort)
        item.isChecked = true
        return super.onOptionsItemSelected(item)
    }

    private fun observeData(type: String, sort: String){
        when (type) {
            SortUtils.TYPE_MOVIE -> {
                favoriteViewModel.getAllMovies(sort).observe(viewLifecycleOwner, { listMovies ->
                    if (listMovies != null) {
                        movieAdapter.submitList(listMovies)
                        binding.progressbar.visibility = View.GONE
                    }
                })
            }
            SortUtils.TYPE_TVSHOW -> {
                favoriteViewModel.getAllTVShows(sort).observe(viewLifecycleOwner, { listTVs ->
                    if (listTVs != null) {
                        tvShowAdapter.submitList(listTVs)
                        binding.progressbar.visibility = View.GONE
                    }
                })
            }
        }
    }
}