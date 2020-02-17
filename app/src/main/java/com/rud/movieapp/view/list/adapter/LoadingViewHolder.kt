package com.rud.movieapp.view.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rud.movieapp.R
import kotlinx.android.synthetic.main.item_loading_view.view.*

class LoadingViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        fun create(retry: () -> Unit, parent: ViewGroup): LoadingViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_loading_view, parent, false)
            view.tvError.setOnClickListener { retry() }
            return LoadingViewHolder(view)
        }
    }
}