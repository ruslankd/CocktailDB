package com.example.cocktaildb.data.cocktail

import com.google.gson.annotations.SerializedName

data class Drinks(
    @SerializedName("drinks")
    val drinks: List<Cocktail>
)