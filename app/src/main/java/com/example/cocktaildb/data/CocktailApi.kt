package com.example.cocktaildb.data

import com.example.cocktaildb.data.cocktail.Cocktail
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface CocktailApi {

    @GET
    fun fetchCocktails(): Single<List<Cocktail>>
}