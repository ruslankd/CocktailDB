package com.example.cocktaildb.data.cocktail.datasource

import com.example.cocktaildb.data.cocktail.Cocktail
import io.reactivex.rxjava3.core.Single

interface CocktailDataSource {
    fun getCocktails(): Single<List<Cocktail>>
}