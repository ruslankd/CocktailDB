package com.example.cocktaildb.data.repository

import com.example.cocktaildb.data.cocktail.Drinks
import com.example.cocktaildb.data.cocktail.datasource.CocktailDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CocktailsRepositoryImpl
@Inject constructor(
    private val cocktailDataSource: CocktailDataSource
) : CocktailsRepository {

    override fun getCocktails(): Single<Drinks> =
        cocktailDataSource.getCocktails()

    override fun getCocktailById(id: String): Single<Drinks> =
        cocktailDataSource.getCocktailById(id)
}