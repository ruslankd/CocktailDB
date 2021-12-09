package com.example.cocktaildb.data.repository

import com.example.cocktaildb.data.cocktail.Cocktail
import com.example.cocktaildb.data.cocktail.datasource.CocktailDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CocktailsRepositoryImpl
@Inject constructor(
    private val cocktailDataSource: CocktailDataSource
): CocktailsRepository {


    override fun getCocktails(): Single<List<Cocktail>> =
        cocktailDataSource.getCocktails()
}