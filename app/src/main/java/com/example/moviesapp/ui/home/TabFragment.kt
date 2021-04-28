package com.example.moviesapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.R
import com.example.moviesapp.adapter.MovieAdapter
import com.example.moviesapp.adapter.TVShowAdapter
import com.example.moviesapp.databinding.FragmentTabBinding
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow
import com.example.moviesapp.ui.detail.DetailActivity
import java.util.ArrayList


class TabFragment : Fragment() {

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        @JvmStatic
        fun newInstance(index: Int) =
                TabFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_SECTION_NUMBER, index)
                    }
                }
    }

    private lateinit var binding: FragmentTabBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTabBinding.bind(view)
        binding.rvFragment.layoutManager = LinearLayoutManager(this.context)
        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)

        val mainViewModel: MainViewModel = ViewModelProvider(this@TabFragment).get(MainViewModel::class.java)

        when (index) {
            1 -> {

                val adapter = MovieAdapter()
                adapter.notifyDataSetChanged()
                binding.rvFragment.adapter = adapter

                mainViewModel.getMovie().observe(viewLifecycleOwner, { listMovies ->
                    if (listMovies != null) {
                        adapter.setMovies(listMovies)
                    }
                })

                adapter.setOnItemClickCallback(object : MovieAdapter.OnItemClickCallback {
                    override fun onItemClicked(data: Movie) {
                        val intent = Intent(activity, DetailActivity::class.java)
                        intent.putExtra(DetailActivity.EXTRA_ID, data.id)
                        intent.putExtra(DetailActivity.EXTRA_TYPE, DetailActivity.EXTRA_MOVIE)
                        startActivity(intent)
                    }

                })
            }

            2 -> {

                val adapter = TVShowAdapter()
                adapter.notifyDataSetChanged()
                binding.rvFragment.adapter = adapter

                mainViewModel.getTVShow().observe(viewLifecycleOwner, { listTVs ->
                    if (listTVs != null) {
                        adapter.setTVShow(listTVs)
                    }
                })

                adapter.setOnItemClickCallback(object : TVShowAdapter.OnItemClickCallback {

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