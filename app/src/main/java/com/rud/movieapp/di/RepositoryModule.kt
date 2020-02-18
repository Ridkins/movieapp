package com.rud.movieapp.di


import com.rud.data.MovieWebService
import com.rud.data.repository.MovieRepositoryImpl
import com.rud.domain.MovieRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideMovieRepo(movieServices: MovieWebService): MovieRepository =
        MovieRepositoryImpl(movieServices)

}