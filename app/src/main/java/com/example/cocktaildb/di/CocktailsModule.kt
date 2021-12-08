package com.example.cocktaildb.di

import com.example.cocktaildb.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface CocktailsModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity
}