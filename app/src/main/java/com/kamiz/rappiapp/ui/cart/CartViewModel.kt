package com.kamiz.rappiapp.ui.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kamiz.rappiapp.data.RappiRepository
import com.kamiz.rappiapp.data.model.Cart
import com.kamiz.rappiapp.data.model.Product
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: RappiRepository,
) : ViewModel() {
    val listOfTheCart: MutableLiveData<Cart> = MutableLiveData()

    fun addProduct(productId:String){
        viewModelScope.launch {
            listOfTheCart.value = repository.addProduct(productId)
        }
    }

}