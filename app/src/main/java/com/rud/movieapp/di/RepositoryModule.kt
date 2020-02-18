package com.rud.movieapp.di


import com.rud.data.MovieWebService
import com.rud.data.repository.MovieRepositoryImpl
import com.rud.domain.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepo(movieServices: MovieWebService): MovieRepository =
        MovieRepositoryImpl(movieServices)

}