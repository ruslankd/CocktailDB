package com.example.cocktaildb.data.repository

import com.example.cocktaildb.data.cocktail.Cocktail
import io.reactivex.rxjava3.core.Single

interface CocktailsRepository {

    fun getCocktails(): Single<List<Cocktail>>
}