package com.rud.movieapp.view.list.datasources

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.rud.domain.MovieRepository
import com.rud.domain.models.Movie
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory(
    private val compositeDisposable: CompositeDisposable,
    private val movieRepository: MovieRepository
) : DataSource.Factory<Int, Movie>() {

    val movieDataSourceLiveData = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val newsDataSource = MovieDataSource(movieRepository, compositeDisposable)
        movieDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}