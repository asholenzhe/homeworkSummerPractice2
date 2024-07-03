package com.example.mysecondhomework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.mysecondhomework.databinding.ItemCatBinding

class CatAdapter(
    private var list: List<Cat>,
    private val glide: RequestManager,
    private val onClick: (Cat) -> Unit
) : RecyclerView.Adapter<CatHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatHolder {
        val binding = ItemCatBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CatHolder(binding, glide, onClick)
    }

    override fun onBindViewHolder(holder: CatHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateDataset(newList: List<Cat>) {
        list = newList
        notifyDataSetChanged()
    }
}
