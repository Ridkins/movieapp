package com.rud.movieapp.di

import android.app.Application
import android.content.Context
import com.google.gson.Gson
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
    fun provideMainActivityViewModelClass(): Class<MovieListViewModel> {
        return MovieListViewModel::class.java
    }


}