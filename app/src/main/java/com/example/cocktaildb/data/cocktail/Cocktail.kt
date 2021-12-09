package com.example.cocktaildb.data.cocktail

import com.google.gson.annotations.SerializedName


data class Cocktail(
    @SerializedName("strDrink") var strDrink: String? = null,
    @SerializedName("strDrinkThumb") var strDrinkThumb: String? = null,
    @SerializedName("idDrink") var idDrink: String? = null
)
