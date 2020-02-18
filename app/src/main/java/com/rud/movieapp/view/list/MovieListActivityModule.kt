package com.rud.movieapp.view.list


import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides


@Module
class MovieListActivityModule {
    @Provides
    fun provideActivity(activity: MovieListActivity): AppCompatActivity {
        return activity
    }

    @Provides
    fun provideFragmentManager(activity: MovieListActivity): FragmentManager {
        return activity.supportFragmentManager
    }
}