package com.example.mysecondhomework

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.mysecondhomework.databinding.ItemCatBinding

class CatHolder(
    private val binding: ItemCatBinding,
    private val glide: RequestManager,
    private val onClick: (Cat) -> Unit,
) : ViewHolder(binding.root) {

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    private val context: Context
        get() = itemView.context

    fun onBind(cat: Cat) {
        binding.run {
            tvName.text = cat.name
            tvBreed.text = cat.breed

            glide
                .load(cat.url)
                .error(R.drawable.baseline_error_24)
                .placeholder(R.drawable.baseline_notifications_active_24)
                .apply(requestOptions)
                .into(ivImage)

            root.setOnClickListener {
                onClick.invoke(cat)
            }

            tvName.setTextColor(context.getColor(cat.getTitleColor()))
        }
    }

    private fun Cat.getTitleColor(): Int = if (url.length > 120) {
        R.color.black
    } else {
        R.color.black
    }
}

