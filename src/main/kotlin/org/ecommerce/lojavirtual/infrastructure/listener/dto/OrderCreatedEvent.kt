package org.ecommerce.lojavirtual.infrastructure.listener.dto

import java.math.BigDecimal
import java.util.UUID

data class OrderCreatedEvent(
    val orderId: UUID,
    val customerId: UUID,
    val orderDate: String,
    val items: List<OrderItemEvent>,
    val totalPrice: BigDecimal,
    val status: String
)
