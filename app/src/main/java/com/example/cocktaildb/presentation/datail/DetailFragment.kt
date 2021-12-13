package com.example.cocktaildb.presentation.datail

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.cocktaildb.R
import com.example.cocktaildb.databinding.FragmentDetailBinding
import com.example.cocktaildb.presentation.android_injector.AndroidInjectorFragment
import com.example.cocktaildb.presentation.cocktails.adapter.CocktailViewModel
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class DetailFragment() : AndroidInjectorFragment(R.layout.fragment_detail), DetailView {

    companion object {
        const val COCKTAIL_ID = "cocktail"

        fun newInstance(cocktailId: String) =
            DetailFragment().apply {
                arguments = bundleOf(COCKTAIL_ID to cocktailId)
            }
    }

    private val cocktailId: String by lazy {
        arguments?.getString(COCKTAIL_ID).orEmpty()
    }

    @Inject
    lateinit var presenterFactory: DetailPresenterAssistedFactory

    val presenter: DetailPresenter by moxyPresenter {
        presenterFactory.create(cocktailId)
    }

    private val viewBinding: FragmentDetailBinding by viewBinding()

    override fun showCocktail(cocktail: CocktailViewModel) {
        with(viewBinding) {
            cocktailName.text = cocktail.name
            Glide.with(requireContext())
                .load(cocktail.url)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progress.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progress.visibility = View.GONE
                        return false
                    }

                })
                .circleCrop()
                .into(cocktailImage)
        }
    }

    override fun showError(error: Throwable) {
        Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
        Log.e("myLog", error.message ?: "")
    }

}