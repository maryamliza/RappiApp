package com.kamiz.rappiapp.ui.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.kamiz.rappiapp.R
import com.kamiz.rappiapp.databinding.FragmentForgotPasswordBinding
import com.kamiz.rappiapp.ui.base.BaseFragment
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

    override fun setupViews() {
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btSend.setOnClickListener {
            viewModel.forgotPassword(email = binding.etEmail.text.toString())
        }
    }

    override fun setupObserver() {
        viewModel.showToast.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, getString(R.string.check_your_email), Toast.LENGTH_SHORT).show()
        })
    }

}