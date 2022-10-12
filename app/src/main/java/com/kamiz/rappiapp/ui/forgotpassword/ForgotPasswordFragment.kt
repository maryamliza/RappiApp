package com.kamiz.rappiapp.ui.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kamiz.rappiapp.databinding.FragmentForgotPasswordBinding
import com.kamiz.rappiapp.ui.base.BaseFragment
import com.kamiz.rappiapp.ui.login.LoginFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForgotPasswordFragment : BaseFragment() {
    val viewModel: ForgotPasswordViewModel by viewModel()
    private lateinit var binding: FragmentForgotPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupObserver() {
    }

    override fun setupViews() {
        binding.back.setOnClickListener{
            findNavController().navigate(ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToLoginFragment())
        }
    }

}