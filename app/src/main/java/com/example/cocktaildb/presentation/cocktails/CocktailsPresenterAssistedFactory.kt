package com.example.cocktaildb.presentation.cocktails

import dagger.assisted.AssistedFactory

@AssistedFactory
interface CocktailsPresenterAssistedFactory {
    fun create(): CocktailsPresenter
}