package org.ecommerce.lojavirtual.infrastructure.listener.dto

import java.util.UUID

data class OrderItemEvent(
    val productId: UUID,
    val quantity: Int,
    val price: Double,
    val unitPrice: Double
)

