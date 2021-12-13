package com.example.cocktaildb.data.cocktail.datasource

import com.example.cocktaildb.data.cocktail.Cocktail
import io.reactivex.rxjava3.core.Observable

interface CocktailCacheDataSource {

    fun getCocktails(): Observable<List<Cocktail>>
    fun getCocktailById(id: String): Observable<Cocktail>
    fun retain(cocktails: List<Cocktail>): Observable<List<Cocktail>>
    fun retain(cocktail: Cocktail): Observable<Cocktail>
}