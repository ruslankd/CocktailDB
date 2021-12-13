package com.example.cocktaildb.presentation.datail

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory

@AssistedFactory
interface DetailPresenterAssistedFactory {
    fun create(
        @Assisted cocktailId: String
    ): DetailPresenter
}