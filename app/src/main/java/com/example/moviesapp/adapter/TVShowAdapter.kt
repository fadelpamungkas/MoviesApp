package com.example.moviesapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviesapp.databinding.CardviewItemBinding
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.TVShow
import java.util.ArrayList

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.CardViewViewHolder>() {

    private var tvShows = ArrayList<TVShow>()
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setTVShow(tvShowList: ArrayList<TVShow>) {
        tvShows.clear()
        tvShows.addAll(tvShowList)
        notifyDataSetChanged()
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val binding = CardviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bind(tvShows[position])
    }

    override fun getItemCount(): Int = tvShows.size

    inner class CardViewViewHolder(private val binding: CardviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TVShow){
            with(binding){
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w185" + tvShow.photo)
                    .into(imageMain)
                titleMain.text = tvShow.title

                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClicked(tvShow)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TVShow)
    }
}