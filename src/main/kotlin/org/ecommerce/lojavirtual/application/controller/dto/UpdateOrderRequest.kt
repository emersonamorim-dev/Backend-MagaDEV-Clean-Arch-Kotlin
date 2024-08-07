package org.ecommerce.lojavirtual.application.controller.dto

import java.util.*

data class UpdateOrderRequest(
    val status: String?,
    val items: List<UpdateOrderItemRequest>?,
    val totalPrice: Double
)

data class UpdateOrderItemRequest(
    val orderItemId: UUID,
    val quantity: Int?,
    val price: Double?
)
