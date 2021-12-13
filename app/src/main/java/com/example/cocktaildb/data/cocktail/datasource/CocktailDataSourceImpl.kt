package com.example.cocktaildb.data.cocktail.datasource

import com.example.cocktaildb.data.newtwork.CocktailApi
import com.example.cocktaildb.data.cocktail.Drinks
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CocktailDataSourceImpl
@Inject constructor(
    private val cocktailApi: CocktailApi
) : CocktailDataSource {
    override fun getCocktails(): Single<Drinks> =
        cocktailApi.fetchCocktails()

    override fun getCocktailById(id: String): Single<Drinks> =
        cocktailApi.fetchCocktailById(id)
}