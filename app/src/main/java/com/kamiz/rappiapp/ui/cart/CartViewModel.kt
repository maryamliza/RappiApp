package com.kamiz.rappiapp.ui.cart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kamiz.rappiapp.data.RappiRepository
import com.kamiz.rappiapp.data.model.Cart
import com.kamiz.rappiapp.data.remote.responses.AddProductRequest
import com.kamiz.rappiapp.data.remote.responses.RemoveProductRequest
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: RappiRepository,
) : ViewModel() {
    var listOfTheCart: MutableLiveData<Cart> = MutableLiveData()

    init {
        getCArt()
    }

    fun addProduct(productId: String) {
        viewModelScope.launch {
            listOfTheCart.value = repository.addProduct(productId)
        }
    }


    fun getCArt() {
        viewModelScope.launch {
            listOfTheCart.value = repository.getCart()
        }
    }

    fun removeProduct(productId: String) {
        viewModelScope.launch {
            listOfTheCart.value = repository.removeProduct(productId)
        }
    }


    fun clearCart() {
        viewModelScope.launch {
            listOfTheCart.value = repository.clearCart()
        }
    }

}