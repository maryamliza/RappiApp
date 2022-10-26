package com.kamiz.rappiapp.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.kamiz.rappiapp.databinding.FragmentCartBinding
import com.kamiz.rappiapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CartFragment : BaseFragment() {
    val viewModel: CartViewModel by sharedViewModel()
    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupViews() {
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.clear.setOnClickListener {

//            MaterialAlertDialogBuilder(requireContext())
//                .setTitle(R.string.title)
//                .setMessage(R.string.supporting_text)
//                .setPositiveButton(R.string.accept) { d, which ->
//                    viewModel.clearCart()
//                }
//                .setNegativeButton(R.string.cancel) { dialog, which ->
////                    Log.e("ASCT", "NO")
//                }
//                .show()
//
            val modalBottomSheet = ModalBottomSheet()
            modalBottomSheet.show(requireActivity().supportFragmentManager, ModalBottomSheet.TAG)
        }

    }

    override fun setupObserver() {
        viewModel.listOfTheCart.observe(viewLifecycleOwner, Observer {

            if (it.productItems.isEmpty()) {
                binding.rcCart.visibility = View.GONE
                binding.emptyCart.visibility = View.VISIBLE
            } else {
                binding.emptyCart.visibility = View.GONE
                binding.rcCart.adapter = CartAdapter(
                    objList = it.productItems,
                    addProductItem = { productId -> viewModel.addProduct(productId) },
                    removeProductItem = { productId -> viewModel.removeProduct(productId) }
                )
            }
        })
    }

}