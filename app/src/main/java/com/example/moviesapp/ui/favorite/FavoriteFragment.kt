package com.example.moviesapp.ui.favorite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
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

        val favoriteViewModel: FavoriteViewModel by activityViewModels()

        when (index) {
            1 -> {

                val adapter = MoviePagingAdapter()
                adapter.notifyDataSetChanged()
                binding.rvFragment.adapter = adapter
                binding.progressbar.visibility = View.VISIBLE

                favoriteViewModel.getAllMovies().observe(viewLifecycleOwner, { listMovies ->
                    if (listMovies != null) {
                        adapter.submitList(listMovies)
                        binding.progressbar.visibility = View.GONE
                    }
                })

                adapter.setOnItemClickCallback(object : MoviePagingAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: Movie) {
                        val intent = Intent(activity, DetailActivity::class.java)
                        intent.putExtra(DetailActivity.EXTRA_ID, data.id)
                        intent.putExtra(DetailActivity.EXTRA_TYPE, DetailActivity.EXTRA_MOVIE)
                        startActivity(intent)
                    }

                })
            }

            2 -> {

                val adapter = TVShowPagingAdapter()
                adapter.notifyDataSetChanged()
                binding.rvFragment.adapter = adapter
                binding.progressbar.visibility = View.VISIBLE

                favoriteViewModel.getAllTVShows().observe(viewLifecycleOwner, { listTVShows ->
                    if (listTVShows != null) {
                        adapter.submitList(listTVShows)
                        binding.progressbar.visibility = View.GONE
                    }
                })

                adapter.setOnItemClickCallback(object : TVShowPagingAdapter.OnItemClickCallback {

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
}