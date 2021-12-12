package com.example.cocktaildb.presentation.cocktails

import com.example.cocktaildb.data.repository.CocktailsRepository
import com.example.cocktaildb.presentation.cocktails.adapter.CocktailViewModel
import com.example.cocktaildb.presentation.datail.DetailScreen
import com.example.cocktaildb.presentation.navigation.CustomRouter
import com.example.cocktaildb.scheduler.Schedulers
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter

class CocktailsPresenter
@AssistedInject constructor(
    private val cocktailsRepository: CocktailsRepository,
    private val schedulers: Schedulers,
    private val router: CustomRouter
) : MvpPresenter<CocktailsView>() {

    private lateinit var disposable: Disposable

    override fun onFirstViewAttach() {
        disposable =
        cocktailsRepository.getCocktails()
            .observeOn(schedulers.background())
            .map { cocktails -> cocktails.drinks.map(CocktailViewModel.Mapper::map) }
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.background())
            .subscribe(
                { cocktails -> viewState.showCocktails(cocktails) },
                { error -> viewState.showError(error) })
    }

    fun displayCocktail(cocktail: CocktailViewModel) {
        router.navigateTo(DetailScreen(cocktail.id ?: "11007"))
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}