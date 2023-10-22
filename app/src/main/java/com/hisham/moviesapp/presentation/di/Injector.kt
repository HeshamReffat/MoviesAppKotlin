package com.hisham.moviesapp.presentation.di

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
}