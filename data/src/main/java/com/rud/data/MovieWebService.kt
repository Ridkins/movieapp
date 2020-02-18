package com.rud.data

import com.rud.data.responses.MovieListResponse
import com.rud.domain.models.Movie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieWebService {

    @GET("movie/upcoming")
    fun getMoviesList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") pageIndex: Int
    ): Single<MovieListResponse<Movie>>

    @GET("movie/{movie_id}")
    fun getMovieDetails(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String,
        @Query("language") language: String?
    ): Single<Movie>

}