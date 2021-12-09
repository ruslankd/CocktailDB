package com.example.cocktaildb

import android.content.Intent
import android.os.Bundle
import com.example.cocktaildb.presentation.cocktails.CocktailsScreen
import com.example.cocktaildb.presentation.navigation.CustomNavigator
import com.example.cocktaildb.presentation.navigation.CustomRouter
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import moxy.MvpAppCompatActivity
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: CustomRouter

    private val navigator = CustomNavigator(this, android.R.id.content)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            router.newRootScreen(CocktailsScreen)
            router.openDeepLink(intent?.data)
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        router.openDeepLink(intent?.data)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

}