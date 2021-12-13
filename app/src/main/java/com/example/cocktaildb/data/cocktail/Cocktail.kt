package com.example.cocktaildb.data.cocktail

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cocktails")
data class Cocktail(
    @ColumnInfo
    @SerializedName("strDrink") var strDrink: String? = null,

    @ColumnInfo
    @SerializedName("strDrinkThumb") var strDrinkThumb: String? = null,

    @PrimaryKey
    @SerializedName("idDrink") var idDrink: String
)
