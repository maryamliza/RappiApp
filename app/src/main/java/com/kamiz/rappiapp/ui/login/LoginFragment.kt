package com.kamiz.rappiapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
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
        binding.etPassword.setText("1234")
        binding.btLogin.setOnClickListener {

            val error = viewModel.checkForErrors(
                email = binding.etEmail.text.toString(),
                password = binding.etPassword.text.toString(),
            )

            if (error == null) {
                viewModel.login(
                    email = binding.etEmail.text.toString(),
                    password = binding.etPassword.text.toString(),
                )
            } else {
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
            }


//            if (loginValid) {
//                viewModel.login(
//                    email = binding.etEmail.text.toString(),
//                    password = binding.etPassword.text.toString(),
//                )
//            } else {
//                Toast.makeText(context, "Invalid format", Toast.LENGTH_SHORT).show()
//            }
        }

        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToForgotPasswordFragment())
        }
    }

    override fun setupObserver() {
        viewModel.tokenResponse.observe(viewLifecycleOwner, Observer {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
        })


        viewModel.error.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
    }
}