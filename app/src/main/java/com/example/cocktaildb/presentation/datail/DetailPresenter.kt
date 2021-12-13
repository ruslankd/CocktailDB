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
            .map { cocktail -> CocktailViewModel.Mapper.map(cocktail)}
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.background())
            .subscribe(
                { cocktail ->
                    viewState.showCocktail(cocktail)
                }, viewState::showError
            )
    }
}