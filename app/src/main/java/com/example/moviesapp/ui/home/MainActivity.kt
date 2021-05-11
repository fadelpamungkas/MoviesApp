package com.example.moviesapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.example.moviesapp.R
import com.example.moviesapp.adapter.SectionsPagerAdapter
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.ui.favorite.FavoriteActivity
import com.example.moviesapp.utils.Constant
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportActionBar?.elevation = 0f

        val sectionsPagerAdapter = SectionsPagerAdapter(this@MainActivity)
        binding.viewPager.adapter = sectionsPagerAdapter

        TabLayoutMediator(binding.tabs, binding.viewPager) { tab, position ->
            tab.text = resources.getString(Constant.TAB_TITLES[position])
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorite ->
                startActivity(Intent(this@MainActivity, FavoriteActivity::class.java))

            else ->
                super.onOptionsItemSelected(item)
        }

        return super.onOptionsItemSelected(item)
    }
}