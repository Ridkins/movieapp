package com.rud.movieapp.di


import com.rud.movieapp.view.detail.MovieDetailActivity
import com.rud.movieapp.view.detail.MovieDetailActivityModule
import com.rud.movieapp.view.list.MovieListActivity
import com.rud.movieapp.view.list.MovieListActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [MovieListActivityModule::class, FragmentBuildersModule::class])
    abstract fun contributeMovieListActivity(): MovieListActivity

    @ContributesAndroidInjector(modules = [MovieDetailActivityModule::class, FragmentBuildersModule::class])
    abstract fun contributeMovieDetailActivity(): MovieDetailActivity
}