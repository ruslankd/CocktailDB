package com.example.cocktaildb.data.cocktail.datasource

import com.example.cocktaildb.data.cocktail.Drinks
import io.reactivex.rxjava3.core.Single

interface CocktailDataSource {
    fun getCocktails(): Single<Drinks>

    fun getCocktailById(id: String): Single<Drinks>
}