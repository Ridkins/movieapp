package com.rud.movieapp.view.list.adapter

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rud.domain.models.Movie
import com.rud.movieapp.BR

class MovieListAdapter(
    private val retry: () -> Unit,
    private val itemClickCallback: ItemClickCallback?
) :
    PagedListAdapter<Movie, RecyclerView.ViewHolder>(MovieDiffCallback) {

    private val DATA_VIEW_TYPE = 1
    private val FOOTER_VIEW_TYPE = 2

    private var state = State.LOADING

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == DATA_VIEW_TYPE) MovieViewHolder.create(
            parent
        ) else LoadingViewHolder.create(retry, parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == DATA_VIEW_TYPE) {
            val binding = DataBindingUtil.bind<ViewDataBinding>(holder.itemView)
            binding?.setVariable(BR.model, getItem(position))
            binding?.setVariable(BR.clickListener, itemClickCallback)
        } else {
            val binding = DataBindingUtil.bind<ViewDataBinding>(holder.itemView)
            binding?.setVariable(BR.state, state)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < super.getItemCount()) DATA_VIEW_TYPE else FOOTER_VIEW_TYPE
    }

    companion object {
        val MovieDiffCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasFooter()) 1 else 0
    }

    private fun hasFooter(): Boolean {
        return super.getItemCount() != 0 && (state == State.LOADING || state == State.ERROR)
    }

    fun setState(state: State) {
        this.state = state
        notifyItemChanged(super.getItemCount())
    }


    interface ItemClickCallback {
        fun onItemClick(movieId: String)
    }

}