package com.rud.domain

import com.rud.domain.models.Movie
import io.reactivex.Single


interface MovieRepository {

    fun getMovieList(pageIndex: Int, pageSize: Int): Single<List<Movie>>


}