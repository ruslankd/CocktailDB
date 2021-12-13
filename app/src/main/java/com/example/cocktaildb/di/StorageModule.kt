package com.example.cocktaildb.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cocktaildb.data.storage.CocktailsStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context): CocktailsStorage =
        Room.databaseBuilder(context, CocktailsStorage::class.java, "drinks.db")
            .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
            .build()
}