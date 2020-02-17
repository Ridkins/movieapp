package com.rud.movieapp.view.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rud.movieapp.R
import kotlinx.android.synthetic.main.item_loading_view.view.*

class LoadingViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(status: State?) {
        itemView.progressBar.visibility = if (status == State.LOADING) VISIBLE else View.INVISIBLE
        itemView.tvError.visibility = if (status == State.ERROR) VISIBLE else View.INVISIBLE
    }

    companion object {
        fun create(retry: () -> Unit, parent: ViewGroup): LoadingViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_loading_view, parent, false)
            view.tvError.setOnClickListener { retry() }
            return LoadingViewHolder(view)
        }
    }
}