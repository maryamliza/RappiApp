package com.kamiz.rappiapp.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kamiz.rappiapp.data.model.ProductItem
import com.kamiz.rappiapp.databinding.FragmentCartBinding
import com.kamiz.rappiapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CartFragment : BaseFragment() {
    val viewModel: CartViewModel by viewModel()
    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupViews() {
        val listProductItem = listOf<ProductItem>()
        binding.rcCart.adapter = CartAdapter(
            objList = listProductItem,
            addProductItem = { productId ->
                viewModel.addProduct(productId)
            }
        )

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun setupObserver() {
    }

}
//
//
//1
//"String"
//true
//12 + 2
//1.0
//1.0 + 4
//4.0 / 4
//"String".size()
//"32442" == "342234"
//10 > 4
//
//
//fun main() {
//
//    val notas = listOf(12, 5, 1, 20)
////    val aprobados = notas.filter { it > 10 }
//
//
//    val aprobados = notas.filter { it > 10}
//    val aprobados2 = notas.filter {nota -> nota > 10}
//
////    val aprobados = notas.filter(::losAprobados)
//}
////
////fun losAprobados(nota: Int): Boolean {
////    return nota > 10
////}