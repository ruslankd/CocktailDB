package com.example.cocktaildb.presentation.cocktails.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cocktaildb.databinding.ItemCocktailBinding

class CocktailViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val viewBinding: ItemCocktailBinding by viewBinding()

    fun bind(cocktailModel: CocktailViewModel, delegate: CocktailsAdapter.Delegate?) {

    }
}