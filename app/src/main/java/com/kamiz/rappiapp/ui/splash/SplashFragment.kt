package com.kamiz.rappiapp.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.kamiz.rappiapp.databinding.FragmentSplashBinding
import com.kamiz.rappiapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment() {
    val viewModel: SplashViewModel by viewModel()
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupViews() {
    }

    override fun setupObserver() {
        viewModel.savedToken.observe(viewLifecycleOwner, Observer {
            if (it!=null){
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
            } else{
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
            }
        })
    }
}