package com.example.moviesapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.databinding.CardviewItemBinding
import com.example.moviesapp.model.TVShow

class TVShowPagingAdapter: PagedListAdapter<TVShow, TVShowPagingAdapter.TVShowViewHolder>(DIFF_CALLBACK) {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TVShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowPagingAdapter.TVShowViewHolder {
        val binding = CardviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        holder.bind(getItem(position) as TVShow)
    }

    inner class TVShowViewHolder(private val binding: CardviewItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(TVShow: TVShow){
            with(binding){
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w185" + TVShow.photo)
                    .into(imageMain)
                titleMain.text = TVShow.title


                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClicked(TVShow)
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<TVShow> = object : DiffUtil.ItemCallback<TVShow>() {
            override fun areItemsTheSame(oldData: TVShow, newData: TVShow): Boolean {
                return oldData.title == newData.title && oldData.description == newData.description
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldData: TVShow, newData: TVShow): Boolean {
                return oldData == newData
            }
        }
    }
}