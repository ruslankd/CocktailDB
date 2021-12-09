package com.example.cocktaildb.presentation.cocktails

import com.example.cocktaildb.data.repository.CocktailsRepository
import com.example.cocktaildb.presentation.cocktails.adapter.CocktailViewModel
import com.example.cocktaildb.scheduler.Schedulers
import com.github.terrakok.cicerone.Router
import dagger.assisted.AssistedInject
import moxy.MvpPresenter

class CocktailsPresenter
@AssistedInject constructor(
    private val cocktailsRepository: CocktailsRepository,
    private val schedulers: Schedulers,
    private val router: Router
) : MvpPresenter<CocktailsView>() {

    override fun onFirstViewAttach() {
        cocktailsRepository.getCocktails()
            .observeOn(schedulers.background())
            .map { cocktails -> cocktails.map(CocktailViewModel.Mapper::map) }
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.background())
            .subscribe(
            )
    }
}