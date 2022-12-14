package com.kamiz.rappiapp.data

import com.kamiz.rappiapp.data.local.LocalDataSource
import com.kamiz.rappiapp.data.model.Cart
import com.kamiz.rappiapp.data.model.Category
import com.kamiz.rappiapp.data.model.Product
import com.kamiz.rappiapp.data.remote.RemoteDataSource
import com.kamiz.rappiapp.data.remote.responses.AddProductRequest
import com.kamiz.rappiapp.data.remote.responses.RemoveProductRequest
import retrofit2.http.Body

class RappiRepository(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource,
) {
    suspend fun login(email: String, password: String): String {
        val token = remote.login(email, password)
        local.saveToken(token)
        return token
    }

    suspend fun forgotPassword(email: String) {
        remote.forgotPassword(email)
    }

    suspend fun getCategories(): List<Category> {
        return remote.getCategories()
    }

    fun getToken(): String? {
        return local.getToken()
    }

    suspend fun createNewUser(){
      remote.createNewUser()
    }

    suspend fun searchText(searchWord: String): List<Product> {
        return remote.searchText(searchWord)
    }

    suspend fun addProduct(productId:String): Cart {
        return remote.addProduct(productId)
    }


    suspend fun getCart(): Cart{
        return remote.getCart()
    }

    suspend fun removeProduct(productId:String): Cart {
        return remote.removeProduct(productId)
    }


    suspend fun clearCart(): Cart {
        return remote.clearCart()
    }

}