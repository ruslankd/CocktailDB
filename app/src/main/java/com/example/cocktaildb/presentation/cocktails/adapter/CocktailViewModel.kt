package com.example.cocktaildb.presentation.cocktails.adapter

import com.example.cocktaildb.data.cocktail.Cocktail

data class CocktailViewModel(
    val name: String?,
    val url: String?,
    val id: String?
) {
    object Mapper {
        fun map(cocktail: Cocktail) =
            CocktailViewModel(
                cocktail.strDrink,
                cocktail.strDrinkThumb,
                cocktail.idDrink
            )
    }
}
