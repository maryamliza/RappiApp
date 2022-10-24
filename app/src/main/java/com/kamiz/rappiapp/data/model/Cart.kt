package com.kamiz.rappiapp.data.model

class Cart(
    val productItems: List<ProductItem>,
    val subtotal: Double = 0.0,
    val discounts: Double = 0.0,
    val discountsLabel: String = "",
    val igv: Double = 0.0,
    val total: Double = 0.0,
) {
}