package com.example.cocktaildb.presentation.cocktails

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object CocktailsScreen: FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        CocktailsFragment.newInstance()

}