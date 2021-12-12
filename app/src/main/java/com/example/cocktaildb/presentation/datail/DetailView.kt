package com.example.cocktaildb.presentation.datail

import com.example.cocktaildb.presentation.cocktails.adapter.CocktailViewModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailView : MvpView {
    fun showCocktail(cocktails: List<CocktailViewModel>)
    fun showError(error: Throwable)
}