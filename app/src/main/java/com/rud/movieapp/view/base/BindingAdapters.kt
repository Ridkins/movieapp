package com.rud.movieapp.view.base


import android.annotation.SuppressLint
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.iarcuschin.simpleratingbar.SimpleRatingBar
import com.rud.movieapp.BuildConfig
import com.rud.movieapp.R


object BindingAdapters {

    @JvmStatic
    @BindingAdapter("viewVisibility")
    fun setVisibility(view: View, isVisible: Boolean) {
        view.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(imageView: AppCompatImageView, imgUrl: String?) {

        Glide.with(imageView.context)
            .load(String.format("%s%s", BuildConfig.BASE_URL_IMG, imgUrl))
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView)
    }

    @SuppressLint("ClickableViewAccessibility")
    @JvmStatic
    @BindingAdapter("rating")
    fun setRating(ratingBar: SimpleRatingBar, popularity: Double) {
        ratingBar.rating = (popularity / 20).toFloat()
        ratingBar.setOnTouchListener { _, _ -> true }
    }


}