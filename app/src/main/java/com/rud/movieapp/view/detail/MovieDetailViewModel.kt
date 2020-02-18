package com.rud.movieapp.view.detail

import androidx.databinding.ObservableField
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.rud.domain.MovieRepository
import com.rud.domain.models.Movie
import com.rud.movieapp.view.base.BaseActivityViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    BaseActivityViewModel() {

    var movie: ObservableField<Movie> = ObservableField()
    private val compositeDisposable = CompositeDisposable()

    fun getMovieDetails(movieId: String) {
        compositeDisposable.add(
            movieRepository.getMovie(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { movie ->
                        this.movie.set(movie)
                    },
                    {
                        this.movie.set(null)
                    }
                )
        )
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        compositeDisposable.dispose()
    }

}