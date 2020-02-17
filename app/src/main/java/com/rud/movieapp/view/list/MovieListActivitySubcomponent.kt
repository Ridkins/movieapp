package com.rud.movieapp.view.list

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [])
interface MovieListActivitySubcomponent : AndroidInjector<MovieListActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MovieListActivity>()
}