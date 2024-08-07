package org.ecommerce.lojavirtual.application.controller.dto

import java.math.BigDecimal
import java.util.*

data class CreateOrderRequest(
    val customerId: UUID,
    val items: List<OrderItemRequest>,
    val status: String

)

data class OrderItemRequest(
    val productId: UUID,
    val quantity: BigDecimal,
    val price: BigDecimal,
    val unitPrice: BigDecimal
)

