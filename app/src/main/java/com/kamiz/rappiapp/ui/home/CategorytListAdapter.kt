package com.kamiz.rappiapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kamiz.rappiapp.data.model.Category
import com.kamiz.rappiapp.databinding.ItemCategoryBinding

class CategorytListAdapter(
    val objList: List<Category>,
) : RecyclerView.Adapter<CategorytListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val obj = objList[position]
        val binding = holder.binding

        binding.categoryName.text = obj.name
        Glide.with(binding.image.context)
            .load(obj.image)
            .into(binding.image)

    }

    override fun getItemCount(): Int {
        return objList.size
    }
}