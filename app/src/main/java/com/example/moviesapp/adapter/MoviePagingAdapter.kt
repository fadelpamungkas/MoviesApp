package com.example.moviesapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.databinding.CardviewItemBinding
import com.example.moviesapp.model.Movie

class MoviePagingAdapter: PagedListAdapter<Movie, MoviePagingAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePagingAdapter.MovieViewHolder {
        val binding = CardviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position) as Movie)
    }

    inner class MovieViewHolder(private val binding: CardviewItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie){
            with(binding){
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w185" + movie.photo)
                    .into(imageMain)
                titleMain.text = movie.title


                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClicked(movie)
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<Movie> = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldData: Movie, newData: Movie): Boolean {
                return oldData.title == newData.title && oldData.description == newData.description
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldData: Movie, newData: Movie): Boolean {
                return oldData == newData
            }
        }
    }
}