package com.example.cocktaildb.presentation.cocktails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cocktaildb.R

class CocktailsAdapter(private val delegate: Delegate?) :
    ListAdapter<CocktailViewModel, CocktailViewHolder>(CocktailsDiff) {

    interface Delegate {
        fun onCocktailPicked(cocktail: CocktailViewModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder =
        CocktailViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_cocktail, parent, false)
        )

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        holder.bind(getItem(position), delegate)
    }
}