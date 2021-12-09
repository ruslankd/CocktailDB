package com.example.cocktaildb.presentation.cocktails

import com.example.cocktaildb.presentation.cocktails.adapter.CocktailViewModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface CocktailsView : MvpView {
    fun showCocktails(cocktails: List<CocktailViewModel>)
}