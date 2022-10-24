package com.kamiz.rappiapp.data.model

class Cart(
    val productItems: List<ProductItem>,
    val subtotal: Double,
    val discounts: Double,
    val discountsLabel: String,
    val igv: Double,
    val total: Double,
) {
}