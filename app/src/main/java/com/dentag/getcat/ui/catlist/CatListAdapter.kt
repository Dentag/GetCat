package com.dentag.getcat.ui.catlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.dentag.getcat.R
import com.dentag.getcat.databinding.ItemCatCardBinding
import com.dentag.getcat.model.entities.Cat

class CatListAdapter(
    private val onItemClickListener: OnItemClickListener
) : PagingDataAdapter<Cat, CatListAdapter.CatViewHolder>(catDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCatCardBinding.inflate(inflater, parent, false)
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CatViewHolder(private val binding: ItemCatCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cat: Cat?) {
            with(binding) {
                itemCatPhoto.load(cat?.url) {
                    crossfade(true)
                    placeholder(
                        ContextCompat.getDrawable(
                            binding.root.context,
                            R.drawable.ic_baseline_hourglass_empty_24
                        )
                    )
                }
                itemCatPhoto.setOnClickListener { view ->
                    cat?.let {
                        onItemClickListener.onItemClick(cat.url, view)
                    }
                }
            }
        }
    }

    companion object {
        private val catDiffUtil = object : DiffUtil.ItemCallback<Cat>() {
            override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
                return oldItem.url == newItem.url
            }
        }
    }
}
