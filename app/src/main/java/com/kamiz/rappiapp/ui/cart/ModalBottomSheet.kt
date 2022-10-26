package com.kamiz.rappiapp.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.kamiz.rappiapp.R
import com.kamiz.rappiapp.databinding.ModalBottomSheetContentBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ModalBottomSheet : BottomSheetDialogFragment() {
    val viewModel: CartViewModel by sharedViewModel()
    private lateinit var binding: ModalBottomSheetContentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ModalBottomSheetContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.title.setText(R.string.title)
        binding.supportingText.setText(R.string.supporting_text)

        binding.btAccept.setOnClickListener {
            viewModel.clearCart()
            dismiss()
        }

        binding.btCancel.setOnClickListener {
            dismiss()
        }
    }
}