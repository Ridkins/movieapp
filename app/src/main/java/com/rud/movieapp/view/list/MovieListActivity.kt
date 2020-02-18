package com.rud.movieapp.view.list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rud.domain.models.Movie
import com.rud.movieapp.R
import com.rud.movieapp.databinding.ActivityMovieListBinding
import com.rud.movieapp.view.base.MvvmActivity
import com.rud.movieapp.view.base.openActivity
import com.rud.movieapp.view.detail.MovieDetailActivity
import com.rud.movieapp.view.list.adapter.MovieListAdapter
import com.rud.movieapp.view.list.adapter.State
import kotlinx.android.synthetic.main.activity_movie_list.*

class MovieListActivity : MvvmActivity<ActivityMovieListBinding, MovieListViewModel>(),
    MovieListAdapter.ItemClickCallback {

    private lateinit var movieListAdapter: MovieListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAndBindContentView(this, savedInstanceState, R.layout.activity_movie_list)
        initAdapter()
        initState()
    }

    override fun onItemClick(movieId: String) {
        openActivity(MovieDetailActivity::class.java) {
            putString(Movie::class.java.simpleName, movieId)
        }
    }

    private fun initAdapter() {
        movieListAdapter =
            MovieListAdapter({ viewModel.retry() }, this)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = movieListAdapter
        viewModel.movieList.observe(this, Observer {
            movieListAdapter.submitList(it)
        })
    }

    private fun initState() {
        viewModel.getState().observe(this, Observer { state ->
            progressBar.visibility =
                if (viewModel.listIsEmpty() && state == State.LOADING) View.VISIBLE else View.GONE
            tvError.visibility =
                if (viewModel.listIsEmpty() && state == State.ERROR) View.VISIBLE else View.GONE
            if (!viewModel.listIsEmpty()) {
                movieListAdapter.setState(state ?: State.DONE)
            }
        })
    }

}