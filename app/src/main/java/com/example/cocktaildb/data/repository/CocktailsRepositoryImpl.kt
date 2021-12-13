package com.example.cocktaildb.data.repository

import com.example.cocktaildb.data.cocktail.Cocktail
import com.example.cocktaildb.data.cocktail.Drinks
import com.example.cocktaildb.data.cocktail.datasource.CocktailCacheDataSource
import com.example.cocktaildb.data.cocktail.datasource.CocktailDataSource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CocktailsRepositoryImpl
@Inject constructor(
    private val cocktailDataSource: CocktailDataSource,
    private val cocktailCacheDataSource: CocktailCacheDataSource
) : CocktailsRepository {

    override fun getCocktails(): Observable<List<Cocktail>> =
        Observable.merge(
            cocktailCacheDataSource
                .getCocktails(),
            cocktailDataSource
                .getCocktails()
                .map { drinks -> drinks.drinks }
                .flatMapObservable(cocktailCacheDataSource::retain)
        )

    override fun getCocktailById(id: String): Observable<Cocktail> =
        Observable.merge(
            cocktailCacheDataSource
                .getCocktailById(id),
            cocktailDataSource
                .getCocktailById(id)
                .map { drinks -> drinks.drinks.first() }
                .toObservable()
        )

}
