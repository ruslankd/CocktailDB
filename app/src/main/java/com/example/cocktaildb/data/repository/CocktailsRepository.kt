package com.example.cocktaildb.data.repository

import com.example.cocktaildb.data.cocktail.Drinks
import io.reactivex.rxjava3.core.Single

interface CocktailsRepository {

    fun getCocktails(): Single<Drinks>

    fun getCocktailById(id: String): Single<Drinks>
}