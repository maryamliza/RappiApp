package com.kamiz.rappiapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.kamiz.rappiapp.databinding.FragmentHomeBinding
import com.kamiz.rappiapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment() {
    val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupObserver() {
        viewModel.categoryList.observe(viewLifecycleOwner, Observer {
            binding.rcCategory.adapter = CategorytListAdapter(it)
        })
    }

    override fun setupViews() {

        binding.search.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSearchFragment())
        }

        binding.btCart.setOnClickListener{
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCartFragment())
        }

    }

}