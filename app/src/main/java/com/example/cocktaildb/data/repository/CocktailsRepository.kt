package com.example.cocktaildb.data.repository

import com.example.cocktaildb.data.cocktail.Cocktail
import com.example.cocktaildb.data.cocktail.Drinks
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface CocktailsRepository {

    fun getCocktails(): Observable<List<Cocktail>>

    fun getCocktailById(id: String): Observable<Cocktail>
}