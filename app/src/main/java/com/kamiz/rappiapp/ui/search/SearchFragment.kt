package com.kamiz.rappiapp.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.kamiz.rappiapp.R
import com.kamiz.rappiapp.databinding.FragmentSearchBinding
import com.kamiz.rappiapp.ui.base.BaseFragment
import com.kamiz.rappiapp.ui.cart.CartViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment() {
    val viewModel: SearchViewModel by viewModel()
    val cartViewModel: CartViewModel by sharedViewModel()
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupViews() {
        binding.etSearch.addTextChangedListener {
            val textToSearch = binding.etSearch.text.toString()
            viewModel.searchText(textToSearch)
        }
        binding.btCart.setOnClickListener {
            findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToCartFragment())
        }
        binding.etSearch.requestFocus()
    }

    override fun setupObserver() {
        viewModel.productList.observe(viewLifecycleOwner, Observer {
            binding.rcItemSearchWord.adapter = ProductListAdapter(
                objList = it,
                addProductItem = { productId -> cartViewModel.addProduct(productId) }
            )
        })

        cartViewModel.listOfTheCart.observe(viewLifecycleOwner, Observer {
            if (it.productItems.isNotEmpty()) {
                binding.btCart.setBackgroundResource(R.drawable.bg_cart_not_empty)
                binding.btCart.setImageResource(R.drawable.ic_cart)
            } else {
                binding.btCart.setBackgroundResource(R.drawable.bg_cart_empty)
                binding.btCart.setImageResource(R.drawable.ic_cart_black)
            }
        })
    }

}
//val addProductItem: (String) -> Unit,
