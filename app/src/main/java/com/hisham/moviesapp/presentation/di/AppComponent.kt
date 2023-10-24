package com.hisham.moviesapp.presentation.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    CacheDataModel::class,
    DatabaseModule::class,
    LocalDataModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
])
interface AppComponent {
    fun movieSubComponent():MovieSubComponent.Factory
}