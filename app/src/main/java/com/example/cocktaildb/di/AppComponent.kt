package com.example.cocktaildb.di

import android.content.Context
import com.example.cocktaildb.App
import com.example.cocktaildb.presentation.navigation.CustomRouter
import com.example.cocktaildb.scheduler.Schedulers
import com.github.terrakok.cicerone.NavigatorHolder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(modules = [AndroidInjectionModule::class, CocktailsModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        @BindsInstance
        fun withRouter(router: CustomRouter): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        fun build(): AppComponent

    }

}