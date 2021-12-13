package com.example.cocktaildb.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cocktaildb.data.cocktail.Cocktail

@Database(exportSchema = false, entities = [Cocktail::class], version = 1)
abstract class CocktailsStorage : RoomDatabase() {
    abstract fun getCocktailDao(): CocktailDao
}