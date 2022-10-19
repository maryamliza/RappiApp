package com.kamiz.rappiapp.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import com.kamiz.rappiapp.databinding.FragmentSearchBinding
import com.kamiz.rappiapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment() {
    val viewModel: SearchViewModel by viewModel()
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

    }

    override fun setupObserver() {
        viewModel.productList.observe(viewLifecycleOwner, Observer {
            binding.rcItemSearchWord.adapter = ProductListAdapter(it)
        })
    }

}