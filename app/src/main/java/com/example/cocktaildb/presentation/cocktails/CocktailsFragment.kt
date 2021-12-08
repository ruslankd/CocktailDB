package com.example.cocktaildb.presentation.cocktails

import com.example.cocktaildb.presentation.android_injector.AndroidInjectorFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class CocktailsFragment : AndroidInjectorFragment() {

    companion object {
        fun newInstance() = CocktailsFragment()
    }

    @Inject
    lateinit var presenterFactory: CocktailsPresenterAssistedFactory

    private val presenter by moxyPresenter {
        presenterFactory.create()
    }
}