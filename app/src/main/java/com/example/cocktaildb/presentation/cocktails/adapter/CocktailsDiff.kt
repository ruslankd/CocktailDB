package com.example.cocktaildb.presentation.cocktails.adapter

import androidx.recyclerview.widget.DiffUtil

object CocktailsDiff : DiffUtil.ItemCallback<CocktailViewModel>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: CocktailViewModel, newItem: CocktailViewModel): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: CocktailViewModel,
        newItem: CocktailViewModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: CocktailViewModel, newItem: CocktailViewModel) = payload
}