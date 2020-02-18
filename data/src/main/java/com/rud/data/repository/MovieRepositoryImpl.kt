package com.rud.data.repository

import com.rud.data.MovieWebService
import com.rud.domain.MovieRepository
import com.rud.domain.models.Movie
import io.reactivex.Single


class MovieRepositoryImpl(
    private val movieWebService: MovieWebService
) : MovieRepository {


    override fun getMovieList(pageIndex: Int, pageSize: Int): Single<List<Movie>> {
        return movieWebService.getMoviesList(
            "f03258aa6d81c5710dfc2cb508cc03ca",
            "us",
            pageIndex,
            null
        )
            .flatMap {
                Single.just(it.results)
            }
    }
}