package com.example.cocktaildb.presentation.navigation

import android.net.Uri
import com.example.cocktaildb.presentation.datail.DetailScreen
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Forward

class OpenDeepLink(private val deepLink: Uri?) : CustomRouter.Command, Command {
    override fun execute(navigator: CustomNavigator) {
        when (deepLink?.authority) {
            "cocktail" ->
                deepLink
                    .let(Uri::getLastPathSegment)
                    ?.let(::DetailScreen)
                    ?.let(::Forward)
                    ?.let(navigator::applyCommand)
            else -> Unit
        }
    }
}