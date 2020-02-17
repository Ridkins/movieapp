package com.rud.movieapp.view.detail


import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides


@Module
class MovieDetailActivityModule {
    @Provides
    fun provideActivity(activity: MovieDetailActivity): AppCompatActivity {
        return activity
    }

    @Provides
    fun provideFragmentManager(activity: MovieDetailActivity): FragmentManager {
        return activity.supportFragmentManager
    }
}