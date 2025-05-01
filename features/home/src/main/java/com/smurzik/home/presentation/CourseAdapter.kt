package com.smurzik.home.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.smurzik.home.R
import com.smurzik.home.databinding.ListItemBinding
import com.smurzik.home.domain.model.Course

class CourseAdapter : RecyclerView.Adapter<CourseViewHolder>() {

    private val courseList = mutableListOf<Course>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.bind(courseList[position])
    }

    override fun getItemCount() = courseList.size

    fun submitList(source: List<Course>) {
        val diffUtil = DiffUtilCallback(courseList, source)
        val diff = DiffUtil.calculateDiff(diffUtil)
        courseList.clear()
        courseList.addAll(source)
        diff.dispatchUpdatesTo(this)
    }
}

class CourseViewHolder(
    private val binding: ListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Course) {
        Glide.with(binding.root).load(R.drawable.cover).into(binding.coverImageView)
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
    }
}

class DiffUtilCallback(
    private val oldList: List<Course>,
    private val newList: List<Course>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}