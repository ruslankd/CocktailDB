package com.example.cocktaildb.data.cocktail.datasource

import com.example.cocktaildb.data.cocktail.Cocktail
import com.example.cocktaildb.data.storage.CocktailsStorage
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CocktailCacheDataSourceImpl
@Inject constructor(
    private val cocktailsStorage: CocktailsStorage
): CocktailCacheDataSource {
    override fun getCocktails(): Observable<List<Cocktail>> =
        cocktailsStorage
            .getCocktailDao()
            .getCocktails()

    override fun getCocktailById(id: String): Observable<Cocktail> =
        cocktailsStorage
            .getCocktailDao()
            .getCocktailById(id)

    override fun retain(cocktails: List<Cocktail>): Observable<List<Cocktail>> =
        cocktailsStorage
            .getCocktailDao()
            .retain(cocktails)
            .andThen(
                cocktailsStorage
                    .getCocktailDao()
                    .getCocktails()
            )

    override fun retain(cocktail: Cocktail): Observable<Cocktail> =
        cocktailsStorage
            .getCocktailDao()
            .retain(cocktail)
            .andThen(
                cocktailsStorage
                    .getCocktailDao()
                    .getCocktailById(cocktail.idDrink)

            )
}