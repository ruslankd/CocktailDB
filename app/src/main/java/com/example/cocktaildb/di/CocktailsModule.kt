package com.example.cocktaildb.di

import com.example.cocktaildb.MainActivity
import com.example.cocktaildb.data.cocktail.datasource.CocktailCacheDataSource
import com.example.cocktaildb.data.cocktail.datasource.CocktailCacheDataSourceImpl
import com.example.cocktaildb.data.cocktail.datasource.CocktailDataSource
import com.example.cocktaildb.data.cocktail.datasource.CocktailDataSourceImpl
import com.example.cocktaildb.data.repository.CocktailsRepository
import com.example.cocktaildb.data.repository.CocktailsRepositoryImpl
import com.example.cocktaildb.presentation.cocktails.CocktailsFragment
import com.example.cocktaildb.presentation.datail.DetailFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [NetworkModule::class, StorageModule::class])
interface CocktailsModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindCocktailsFragment(): CocktailsFragment

    @ContributesAndroidInjector
    fun bindDetailFragment(): DetailFragment

    @Binds
    fun bindCocktailRepository(
        cocktailsRepository: CocktailsRepositoryImpl
    ): CocktailsRepository

    @Binds
    fun bindCocktailDataSource(
        cocktailDataSource: CocktailDataSourceImpl
    ): CocktailDataSource

    @Binds
    fun bindCocktailCacheDataSource(
        cocktailCacheDataSource: CocktailCacheDataSourceImpl
    ): CocktailCacheDataSource

}