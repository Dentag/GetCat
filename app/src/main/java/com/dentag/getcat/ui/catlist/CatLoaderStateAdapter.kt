package com.dentag.getcat.ui.catlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dentag.getcat.databinding.ItemProgressBinding

class CatLoaderStateAdapter : LoadStateAdapter<CatLoaderStateAdapter.ProgressViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ProgressViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProgressBinding.inflate(inflater, parent, false)
        return ProgressViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProgressViewHolder, loadState: LoadState) {
    }

    inner class ProgressViewHolder(binding: ItemProgressBinding) :
        RecyclerView.ViewHolder(binding.root)
}
