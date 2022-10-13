package com.kamiz.rappiapp.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
    }
}