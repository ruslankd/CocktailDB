package com.example.cocktaildb.presentation.datail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class DetailScreen(private val cocktailId: String): FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        DetailFragment.newInstance(cocktailId)
}