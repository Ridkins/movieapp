package com.rud.movieapp.view.detail

import android.os.Bundle
import com.rud.domain.models.Movie
import com.rud.movieapp.R
import com.rud.movieapp.databinding.ActivityMovieDetailBinding
import com.rud.movieapp.view.base.EXTRA_ARG
import com.rud.movieapp.view.base.MvvmActivity

class MovieDetailActivity : MvvmActivity<ActivityMovieDetailBinding, MovieDetailViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setAndBindContentView(this, savedInstanceState, R.layout.activity_movie_detail)
        initToolbar()
        if (savedInstanceState == null && intent.hasExtra(EXTRA_ARG)) {
            val movieId = intent.getBundleExtra(EXTRA_ARG)?.getString(Movie::class.java.simpleName)
            viewModel.getMovieDetails(movieId ?: return)
        }
    }

    private fun initToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = getString(R.string.movie_detail)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}