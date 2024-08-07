package org.ecommerce.lojavirtual.application.dto

import java.util.UUID


data class OrderDto(
    val id: UUID?,
    val userId: UUID,
    val productIds: Set<UUID?>,
    val totalAmount: Double
)
