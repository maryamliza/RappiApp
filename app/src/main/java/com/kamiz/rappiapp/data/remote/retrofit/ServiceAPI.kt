package com.kamiz.rappiapp.data.remote.retrofit

import com.kamiz.rappiapp.data.model.Cart
import com.kamiz.rappiapp.data.model.Category
import com.kamiz.rappiapp.data.model.Product
import com.kamiz.rappiapp.data.remote.responses.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ServiceAPI {
    @POST("login")
    suspend fun login(@Body body: LoginRequest): LoginResponse

    @POST("forgotpassword")
    suspend fun forgotPassword(@Body body: ForgotPasswordRequest): Response<Any?>
    // Response<Any?> is handling 204 response

    @GET("categories")
    suspend fun getCategories(): List<Category>

    @POST("signup")
    suspend fun createNewUser(): Response<Any>

    @GET("search")
    suspend fun searchText(@Query("product") searchWord: String): List<Product>

    @GET("cart")
    suspend fun getCart(): Cart

    @POST("cart/clear")
    suspend fun clearCart(): Cart

    /** Add 1 product to the cart */
    @POST("cart/add_product")
    suspend fun addProduct(@Body body: AddProductRequest): Cart

    /** Remove only 1 product of the cart */
    @POST("cart/remove_product")
    suspend fun removeProduct(@Body body: RemoveProductRequest): Cart

    @POST("cart/apply_coupon")
    suspend fun applyCoupon(@Body body: ApplyCouponRequest): Cart

}