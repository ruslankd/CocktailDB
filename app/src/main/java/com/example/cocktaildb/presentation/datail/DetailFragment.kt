package com.example.cocktaildb.presentation.datail

import androidx.core.os.bundleOf
import com.example.cocktaildb.presentation.android_injector.AndroidInjectorFragment

class DetailFragment() : AndroidInjectorFragment() {

    companion object {
        const val COCKTAIL_NAME = "cocktail"

        fun newInstance(cocktailName: String) =
            DetailFragment().apply {
                arguments = bundleOf(COCKTAIL_NAME to cocktailName)
            }
    }

    private val cocktailName: String by lazy {
        arguments?.getString(COCKTAIL_NAME).orEmpty()
    }
}