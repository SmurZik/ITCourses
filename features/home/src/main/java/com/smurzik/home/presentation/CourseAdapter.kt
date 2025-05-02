package com.smurzik.home.presentation

import android.view.ViewOutlineProvider
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.smurzik.home.R
import com.smurzik.home.databinding.ListItemBinding
import com.smurzik.home.domain.model.Course

class CourseAdapter : AsyncListDifferDelegationAdapter<Course>(
    DiffUtilCallback()
) {
    init {
        delegatesManager.addDelegate(courseAdapterDelegate())
    }
}

fun courseAdapterDelegate() = adapterDelegateViewBinding<Course, Course, ListItemBinding>(
    viewBinding = { layoutInflater, parent ->
        ListItemBinding.inflate(
            layoutInflater,
            parent,
            false
        )
    }
) {
    bind {
        val cover = when (item.id % 3) {
            1 -> R.drawable.cover
            2 -> R.drawable.cover1
            else -> R.drawable.cover2
        }
        Glide.with(binding.root).load(cover).into(binding.coverImageView)
        binding.ratingTextView.text = item.rate
        binding.dateTextView.text = item.startDate
        binding.titleTextView.text = item.title
        binding.textTextView.text = item.text
        binding.priceTextView.text = item.price

        binding.starBlurLayout.setupWith(binding.root).setBlurRadius(20f)
        binding.starBlurLayout.outlineProvider = (ViewOutlineProvider.BACKGROUND)
        binding.starBlurLayout.clipToOutline = true

        binding.favoriteBlurLayout.setupWith(binding.root).setBlurRadius(20f)
        binding.favoriteBlurLayout.outlineProvider = (ViewOutlineProvider.BACKGROUND)
        binding.favoriteBlurLayout.clipToOutline = true

        binding.dataBlurLayout.setupWith(binding.root).setBlurRadius(20f)
        binding.dataBlurLayout.outlineProvider = (ViewOutlineProvider.BACKGROUND)
        binding.dataBlurLayout.clipToOutline = true

        if (item.hasLike) binding.favoriteImageView.setImageResource(R.drawable.ic_favorite_fill)
    }
}

class DiffUtilCallback : DiffUtil.ItemCallback<Course>() {

    override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
        return oldItem == newItem
    }
}