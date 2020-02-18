package com.rud.movieapp.view.list

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.rud.domain.MovieRepository
import com.rud.domain.models.Movie
import com.rud.movieapp.view.base.BaseActivityViewModel
import com.rud.movieapp.view.list.adapter.State
import com.rud.movieapp.view.list.datasources.MovieDataSource
import com.rud.movieapp.view.list.datasources.MovieDataSourceFactory
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MovieListViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    BaseActivityViewModel() {

    var movieList: LiveData<PagedList<Movie>>
    private val compositeDisposable = CompositeDisposable()
    private val pageSize = 5
    private val movieDataSourceFactory: MovieDataSourceFactory

    init {
        movieDataSourceFactory = MovieDataSourceFactory(compositeDisposable, movieRepository)
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()
        movieList = LivePagedListBuilder(movieDataSourceFactory, config).build()
    }


    fun getState(): LiveData<State> = Transformations.switchMap<MovieDataSource,
            State>(movieDataSourceFactory.movieDataSourceLiveData, MovieDataSource::state)

    fun retry() {
        movieDataSourceFactory.movieDataSourceLiveData.value?.retry()
    }

    fun listIsEmpty(): Boolean {
        return movieList.value?.isEmpty() ?: true
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        compositeDisposable.dispose()
    }

}