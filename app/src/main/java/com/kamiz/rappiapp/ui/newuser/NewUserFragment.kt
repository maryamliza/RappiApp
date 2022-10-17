package com.kamiz.rappiapp.ui.newuser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.kamiz.rappiapp.databinding.FragmentNewUserBinding
import com.kamiz.rappiapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewUserFragment : BaseFragment() {
    val viewModel: NewUserViewModel by viewModel()
    private lateinit var binding: FragmentNewUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupViews() {
        binding.btSignUp.setOnClickListener {
            viewModel.tryNewUser(
                name = binding.etName.text.toString(),
                email = binding.etEmail.text.toString(),
                password = binding.etPassword.text.toString(),
                confirmPassword = binding.etConfirmPassword.text.toString(),
            )
        }
    }

    override fun setupObserver() {
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        })
    }

}