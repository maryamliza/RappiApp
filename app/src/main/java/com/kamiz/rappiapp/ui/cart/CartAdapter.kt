package com.kamiz.rappiapp.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kamiz.rappiapp.data.model.ProductItem
import com.kamiz.rappiapp.databinding.ItemCartBinding
import com.kamiz.rappiapp.di.viewModelsModule

class CartAdapter(
    val objList: List<ProductItem>,
    val addProductItem: (String) -> Unit,
//    val removeProductItem: (String) -> Unit,

) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCartBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val obj = objList[position]
        val binding = holder.binding

        binding.productName.text = obj.product.name
        Glide.with(binding.image.context)
            .load(obj.product.photoUrl)
            .into(binding.image)
        binding.productQuantity.text = obj.quantity.toString()

        binding.btAdd.setOnClickListener{
            addProductItem(obj.product.id)
        }

    }

    override fun getItemCount(): Int {
        return objList.size
    }
}