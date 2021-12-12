package com.example.cocktaildb.data

import com.example.cocktaildb.data.cocktail.Drinks
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApi {

    @GET("filter.php?a=Alcoholic")
    fun fetchCocktails(): Single<Drinks>

    @GET("lookup.php")
    fun fetchCocktailById(@Query("i") id: String): Single<Drinks>
}