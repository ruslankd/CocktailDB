package com.example.cocktaildb.data.cocktail.datasource

import com.example.cocktaildb.data.CocktailApi
import com.example.cocktaildb.data.cocktail.Cocktail
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CocktailDataSourceImpl
@Inject constructor(
    private val cocktailApi: CocktailApi
): CocktailDataSource{
    override fun getCocktails(): Single<List<Cocktail>> =
        cocktailApi.fetchCocktails()
}