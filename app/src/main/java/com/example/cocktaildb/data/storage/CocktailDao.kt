package com.example.cocktaildb.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.cocktaildb.data.cocktail.Cocktail
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface CocktailDao {

    @Query("SELECT * FROM cocktails")
    fun getCocktails(): Observable<List<Cocktail>>

    @Query("SELECT * FROM cocktails WHERE idDrink LIKE :id LIMIT 1")
    fun getCocktailById(id: String): Observable<Cocktail>

    @Insert(onConflict = REPLACE)
    fun retain(cocktails: List<Cocktail>): Completable

    @Insert(onConflict = REPLACE)
    fun retain(cocktail: Cocktail): Completable
}