package com.example.moviesapp.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.example.moviesapp.R
import com.example.moviesapp.adapter.FavoritePagerAdapter
import com.example.moviesapp.adapter.SectionsPagerAdapter
import com.example.moviesapp.databinding.ActivityFavoriteBinding
import com.example.moviesapp.utils.Constant
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        val sectionsPagerAdapter = FavoritePagerAdapter(this@FavoriteActivity)
        binding.viewPager.adapter = sectionsPagerAdapter

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(Constant.TAB_TITLES[position])
        }.attach()
    }
}