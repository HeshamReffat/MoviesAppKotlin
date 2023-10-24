package com.hisham.moviesapp

import android.app.Application
import com.hisham.moviesapp.presentation.di.AppComponent
import com.hisham.moviesapp.presentation.di.AppModule
import com.hisham.moviesapp.presentation.di.DaggerAppComponent
import com.hisham.moviesapp.presentation.di.Injector
import com.hisham.moviesapp.presentation.di.MovieSubComponent
import com.hisham.moviesapp.presentation.di.NetModule
import com.hisham.moviesapp.presentation.di.RemoteDataModule

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent =
            DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .netModule(NetModule(BuildConfig.MAIN_URL))
                .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
                .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }
}