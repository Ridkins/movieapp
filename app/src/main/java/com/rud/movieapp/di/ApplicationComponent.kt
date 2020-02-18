package com.rud.movieapp.di

import android.app.Application
import com.rud.movieapp.MovieApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class, ViewModelFactoryModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        ViewModelModule::class]
)

interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: MovieApplication)
}