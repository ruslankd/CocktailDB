package com.example.cocktaildb.presentation.cocktails

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cocktaildb.R
import com.example.cocktaildb.databinding.FragmentCocktailsBinding
import com.example.cocktaildb.presentation.android_injector.AndroidInjectorFragment
import com.example.cocktaildb.presentation.cocktails.adapter.CocktailViewModel
import com.example.cocktaildb.presentation.cocktails.adapter.CocktailsAdapter
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class CocktailsFragment : AndroidInjectorFragment(R.layout.fragment_cocktails), CocktailsView, CocktailsAdapter.Delegate {

    companion object {
        fun newInstance() = CocktailsFragment()
    }

    @Inject
    lateinit var presenterFactory: CocktailsPresenterAssistedFactory

    private val presenter by moxyPresenter {
        presenterFactory.create()
    }

    private val viewBinding: FragmentCocktailsBinding by viewBinding()
    private val cocktailAdapter = CocktailsAdapter(delegate = this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.rvCocktails.adapter = cocktailAdapter
    }

    override fun showCocktails(cocktails: List<CocktailViewModel>) {
        cocktailAdapter.submitList(cocktails)
    }

    override fun onCocktailPicked(cocktail: CocktailViewModel) {

    }
}