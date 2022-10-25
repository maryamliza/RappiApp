package com.kamiz.rappiapp.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.kamiz.rappiapp.databinding.FragmentCartBinding
import com.kamiz.rappiapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartFragment : BaseFragment() {
    val viewModel: CartViewModel by viewModel()
    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupViews() {
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun setupObserver() {
        viewModel.listOfTheCart.observe(viewLifecycleOwner, Observer {
            binding.rcCart.adapter = CartAdapter(
                objList = it.productItems,
                addProductItem = { productId -> viewModel.addProduct(productId) },
                removeProductItem = {productId -> viewModel.removeProduct(productId)}
            )
        })
    }

}