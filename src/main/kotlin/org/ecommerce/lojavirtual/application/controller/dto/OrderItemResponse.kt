package org.ecommerce.lojavirtual.application.controller.dto

import org.ecommerce.lojavirtual.domain.entity.OrderItemEntity
import java.math.BigDecimal
import java.util.UUID

data class OrderItemResponse(
    val id: UUID,
    val productId: UUID,
    val quantity: Int,
    val unitPrice: Double
) {
    companion object {
        fun fromEntity(entity: OrderItemEntity): OrderItemResponse {
            return OrderItemResponse(
                id = entity.id!!,
                productId = entity.product.id ?: throw IllegalArgumentException("Product ID cannot be null"),
                quantity = entity.quantity,
                unitPrice = entity.unitPrice
            )
        }
    }
}


