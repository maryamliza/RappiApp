package com.kamiz.rappiapp.data.remote

import com.kamiz.rappiapp.data.model.Cart
import com.kamiz.rappiapp.data.model.Category
import com.kamiz.rappiapp.data.model.Product
import com.kamiz.rappiapp.data.model.ProductItem
import com.kamiz.rappiapp.data.remote.responses.AddProductRequest
import com.kamiz.rappiapp.data.remote.responses.ForgotPasswordRequest
import com.kamiz.rappiapp.data.remote.responses.LoginRequest
import com.kamiz.rappiapp.data.remote.responses.RemoveProductRequest
import com.kamiz.rappiapp.data.remote.retrofit.ServiceAPI
import retrofit2.http.Body

private val TEST_PRODUCT_1 = Product(
    "Gelatina roja",
    "https://wongfood.vteximg.com.br/arquivos/ids/492695-1000-1000/frontal-146.jpg?v=637716658010600000",
    id = "1",
    price = 5.0,
)
private val TEST_PRODUCT_2 = Product(
    "Gelatina amarilla",
    "https://wongfood.vteximg.com.br/arquivos/ids/492695-1000-1000/frontal-146.jpg?v=637716658010600000",
    id = "2",
    price = 5.0,
)
private val TEST_PRODUCT_3 = Product(
    "Gelatina verde",
    "https://wongfood.vteximg.com.br/arquivos/ids/492695-1000-1000/frontal-146.jpg?v=637716658010600000",
    id = "3",
    price = 5.0,
)
private val TEST_PRODUCT_4 = Product(
    "Gelatina naranja",
    "https://wongfood.vteximg.com.br/arquivos/ids/492695-1000-1000/frontal-146.jpg?v=637716658010600000",
    id = "4",
    price = 5.0,
)
private val TEST_PRODUCT_5 = Product(
    "Gelatina rosada",
    "https://wongfood.vteximg.com.br/arquivos/ids/492695-1000-1000/frontal-146.jpg?v=637716658010600000",
    id = "5",
    price = 5.0,
)
private val TEST_PRODUCT_6 = Product(
    "Gelatina morada",
    "https://wongfood.vteximg.com.br/arquivos/ids/492695-1000-1000/frontal-146.jpg?v=637716658010600000",
    id = "6",
    price = 5.0,
)


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
                Category(
                    "Abarrotes",
                    "https://www.recetasnestle.com.mx/sites/default/files/srh_recipes/a7a1dc0004804778ac64cb26b8217c5c.jpeg"
                ),
                Category(
                    "Desayunos",
                    "https://www.recetasnestle.com.mx/sites/default/files/srh_recipes/a7a1dc0004804778ac64cb26b8217c5c.jpeg"
                ),
                Category(
                    "Lacteos",
                    "https://www.recetasnestle.com.mx/sites/default/files/srh_recipes/a7a1dc0004804778ac64cb26b8217c5c.jpeg"
                ),
                Category(
                    "Fiambres",
                    "https://www.recetasnestle.com.mx/sites/default/files/srh_recipes/a7a1dc0004804778ac64cb26b8217c5c.jpeg"
                ),
                Category(
                    "Congelados",
                    "https://www.recetasnestle.com.mx/sites/default/files/srh_recipes/a7a1dc0004804778ac64cb26b8217c5c.jpeg"
                ),
                Category(
                    "Carnes",
                    "https://www.recetasnestle.com.mx/sites/default/files/srh_recipes/a7a1dc0004804778ac64cb26b8217c5c.jpeg"
                ),
                Category(
                    "Frutas y Verduras",
                    "https://www.recetasnestle.com.mx/sites/default/files/srh_recipes/a7a1dc0004804778ac64cb26b8217c5c.jpeg"
                ),
                Category(
                    "Panaderia",
                    "https://www.recetasnestle.com.mx/sites/default/files/srh_recipes/a7a1dc0004804778ac64cb26b8217c5c.jpeg"
                ),
            )
        }
    }

    suspend fun createNewUser() {
        service.createNewUser()
    }

    suspend fun searchText(searchWord: String): List<Product> {
        try {
            return service.searchText(searchWord)
        } catch (e: Exception) {
            return if (searchWord == "") listOf()
            else listOf<Product>(
                TEST_PRODUCT_1,
                TEST_PRODUCT_2,
                TEST_PRODUCT_3,
                TEST_PRODUCT_4,
                TEST_PRODUCT_5,
                TEST_PRODUCT_6,
            )
        }
    }


    suspend fun addProduct(productId: String): Cart {
        try {
            val body = AddProductRequest(productId = productId)
            return service.addProduct(body)
        } catch (e: Exception) {
            return Cart(
                listOf<ProductItem>(
                    ProductItem(TEST_PRODUCT_1, 2),
                    ProductItem(TEST_PRODUCT_2, 2),
                    ProductItem(TEST_PRODUCT_3, 3),
                    ProductItem(TEST_PRODUCT_4, 4),
                    ProductItem(TEST_PRODUCT_5, 5),
                    ProductItem(TEST_PRODUCT_6, 6),
                )
            )
        }
    }


    suspend fun getCart(): Cart {
        try {
            return service.getCart()
        } catch (e:Exception) {
            return Cart(
                listOf<ProductItem>(
//                    ProductItem(TEST_PRODUCT_1, 1),
//                    ProductItem(TEST_PRODUCT_2, 2),
//                    ProductItem(TEST_PRODUCT_3, 3),
//                    ProductItem(TEST_PRODUCT_4, 4),
//                    ProductItem(TEST_PRODUCT_5, 5),
//                    ProductItem(TEST_PRODUCT_6, 6),
                )
            )
        }
    }


    suspend fun removeProduct(productId: String): Cart {
        try {
            val body = RemoveProductRequest(productId)
            return service.removeProduct(body)
        } catch (e: Exception) {
            return Cart(
                listOf<ProductItem>(
                    ProductItem(TEST_PRODUCT_1, 1),
                    ProductItem(TEST_PRODUCT_2, 1),
                    ProductItem(TEST_PRODUCT_3, 2),
                    ProductItem(TEST_PRODUCT_4, 3),
                    ProductItem(TEST_PRODUCT_5, 4),
                    ProductItem(TEST_PRODUCT_6, 5),
                )
            )
        }
    }


    suspend fun clearCart():Cart{
        try {
           return service.clearCart()
        } catch(e:Exception){
            return Cart(
                listOf<ProductItem>(
                )
            )
        }
    }
}
