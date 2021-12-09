package com.example.cocktaildb

import com.example.cocktaildb.presentation.navigation.CustomRouter
import com.example.cocktaildb.scheduler.SchedulersFactory
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent
            .builder()
            .withContext(applicationContext)
            .withSchedulers(SchedulersFactory.create())
            .apply {
                val cicerone = Cicerone.create(CustomRouter())
                withRouter(cicerone.router)
                withNavigatorHolder(cicerone.getNavigatorHolder())
            }
            .build()
}