package com.rud.movieapp.di

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.rud.movieapp.view.detail.MovieDetailViewModel
import com.rud.movieapp.view.list.MovieListViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: Application): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideMovieListActivityViewModelClass(): Class<MovieListViewModel> {
        return MovieListViewModel::class.java
    }

    @Provides
    fun provideMovieDetailsActivityViewModelClass(): Class<MovieDetailViewModel> {
        return MovieDetailViewModel::class.java
    }

}