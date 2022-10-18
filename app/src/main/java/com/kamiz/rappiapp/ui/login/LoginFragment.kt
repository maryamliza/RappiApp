package com.kamiz.rappiapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.kamiz.rappiapp.databinding.FragmentLoginBinding
import com.kamiz.rappiapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment() {
    val viewModel: LoginViewModel by viewModel()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupViews() {

        binding.etEmail.setText("test@test.com")
        binding.etPassword.setText("123456Ml!")
        binding.btLogin.setOnClickListener {
            viewModel.tryLogin(
                email = binding.etEmail.text.toString(),
                password = binding.etPassword.text.toString(),
            )
        }

        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToForgotPasswordFragment())

        }
        binding.createNewUser.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToNewUserFragment())
        }
    }

    override fun setupObserver() {
        viewModel.tokenResponse.observe(viewLifecycleOwner, Observer {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
        })


        viewModel.showErrorToast.observe(viewLifecycleOwner, Observer {
//            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        })
    }
}