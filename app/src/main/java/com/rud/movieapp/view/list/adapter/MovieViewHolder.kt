package com.rud.movieapp.view.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rud.domain.models.Movie
import com.rud.movieapp.BuildConfig
import com.rud.movieapp.R
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(movie: Movie?) {
        if (movie != null) {
            itemView.tvMovieTitle.text = movie.title
            itemView.tvReleaseDate.text = movie.releaseDate
            itemView.starsRating.rating = (movie.popularity / 20).toFloat()
            itemView.starsRating.setOnTouchListener { _, _ -> true }
            Glide.with(itemView.ivPhoto?.context ?: return)
                .load(String.format("%s%s", BuildConfig.BASE_URL_IMG, movie.posterPath))
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(itemView.ivPhoto ?: return)
        }
    }

    companion object {
        fun create(parent: ViewGroup): MovieViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
            return MovieViewHolder(view)
        }
    }
}