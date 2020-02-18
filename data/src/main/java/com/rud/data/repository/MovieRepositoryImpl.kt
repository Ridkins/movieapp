package com.rud.data.repository

import com.rud.data.MovieWebService
import com.rud.domain.Constants
import com.rud.domain.MovieRepository
import com.rud.domain.models.Movie
import io.reactivex.Single


class MovieRepositoryImpl(
    private val movieWebService: MovieWebService
) : MovieRepository {


    override fun getMovieList(pageIndex: Int, pageSize: Int): Single<List<Movie>> {
        return movieWebService.getMoviesList(
            Constants.MOVIE_API_KEY, "us", pageIndex
        )
            .flatMap {
                Single.just(it.results)
            }
    }

    override fun getMovie(movieId: String): Single<Movie> {
        return movieWebService.getMovieDetails(movieId, Constants.MOVIE_API_KEY, "us")
    }
}