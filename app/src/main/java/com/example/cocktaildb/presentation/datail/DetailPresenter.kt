package com.example.cocktaildb.presentation.datail

import com.example.cocktaildb.data.repository.CocktailsRepository
import com.example.cocktaildb.presentation.cocktails.adapter.CocktailViewModel
import com.example.cocktaildb.scheduler.Schedulers
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import moxy.MvpPresenter

class DetailPresenter
@AssistedInject constructor(
    @Assisted private val cocktailId: String,
    private val cocktailsRepository: CocktailsRepository,
    private val schedulers: Schedulers
) : MvpPresenter<DetailView>() {

    override fun onFirstViewAttach() {
        cocktailsRepository.getCocktailById(cocktailId)
            .map { cocktails -> cocktails.drinks.map(CocktailViewModel.Mapper::map) }
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.background())
            .subscribe({ cocktails -> viewState.showCocktail(cocktails) }, viewState::showError)
    }
}