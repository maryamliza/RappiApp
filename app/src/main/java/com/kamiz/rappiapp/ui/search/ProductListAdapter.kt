package com.kamiz.rappiapp.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kamiz.rappiapp.data.model.Category
import com.kamiz.rappiapp.data.model.Product
import com.kamiz.rappiapp.databinding.ItemCategoryBinding
import com.kamiz.rappiapp.databinding.ItemProductBinding

class ProductListAdapter(
    val objList: List<Product>,
    val addProductItem: (String) -> Unit,

    ) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val obj = objList[position]
        val binding = holder.binding
        binding.productName.text = obj.name
        Glide.with(binding.image.context)
            .load(obj.photoUrl)
            .into(binding.image)

        binding.btAdd.setOnClickListener {
            addProductItem(obj.id)
        }
    }

    override fun getItemCount(): Int {
        return objList.size
    }
}