package com.kamiz.rappiapp.data.remote

import com.kamiz.rappiapp.data.model.Category
import com.kamiz.rappiapp.data.model.Product
import com.kamiz.rappiapp.data.remote.responses.ForgotPasswordRequest
import com.kamiz.rappiapp.data.remote.responses.LoginRequest
import com.kamiz.rappiapp.data.remote.retrofit.ServiceAPI

class RemoteDataSource(
    private val service: ServiceAPI
) {
    suspend fun login(email: String, password: String): String {
        val body = LoginRequest(email = email, password = password)
        val response = service.login(body)
        return response.token
    }

    suspend fun forgotPassword(email: String) {
        val body = ForgotPasswordRequest(email)
        service.forgotPassword(body)
    }

    suspend fun getCategories(): List<Category> {
        try {
            return service.getCategories()
//            TODO: Remove when API ready
        } catch (e: Exception) {
            return listOf<Category>(
                Category("Restaurante"),
                Category("Supermercado"),
                Category("Farmacia"),
                Category("Turbo"),
                Category("La Cesta Super"),
                Category("RappiMall"),
                Category("Licor"),
                Category("Rappifavor"),
            )
        }
    }

    suspend fun createNewUser() {
        service.createNewUser()
    }

    suspend fun searchText(searchWord: String): List<Product> {
        try {
            return service.searchText(searchWord)
        } catch (e: java.lang.Exception) {
            return if (searchWord == "") listOf()
            else listOf<Product>(
                Product("Gelatina roja"),
                Product("Gelatina amarilla"),
                Product("Gelatina verde"),
                Product("Gelatina naranja"),
                Product("Gelatina rosada"),
                Product("Gelatina morada"),
            )
        }
    }


}
