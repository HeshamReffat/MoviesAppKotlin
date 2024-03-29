package com.hisham.moviesapp.presentation.di

import com.hisham.moviesapp.MainActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(movieActivity:MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}