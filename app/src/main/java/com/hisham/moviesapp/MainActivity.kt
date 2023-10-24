package com.hisham.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hisham.moviesapp.R
import com.hisham.moviesapp.data.model.Movie
import com.hisham.moviesapp.databinding.ActivityMainBinding
import com.hisham.moviesapp.presentation.MovieAdapter
import com.hisham.moviesapp.presentation.MyViewModel
import com.hisham.moviesapp.presentation.ViewModelFactory
import com.hisham.moviesapp.presentation.di.Injector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory
    private lateinit var movieViewModel: MyViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)

        initRecycleView()
    }

    private fun initRecycleView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.recyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setMovies(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(this, "No Data Available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = MenuInflater(this)
        inflater.inflate(R.menu.refresh, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovie()
        response.observe(this, Observer {

            if (it != null) {
                adapter.setMovies(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE

            }
        })
    }
}