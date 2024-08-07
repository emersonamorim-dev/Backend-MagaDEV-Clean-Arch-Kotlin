package org.ecommerce.lojavirtual.application.controller.dto

import org.ecommerce.lojavirtual.domain.entity.OrderEntity
import java.math.BigDecimal
import java.util.UUID

data class OrderResponse(
    val id: UUID,
    val orderDate: String,
    val totalPrice: BigDecimal,
    val status: String,
    val items: List<OrderItemResponse>
) {
    companion object {
        fun fromEntity(entity: OrderEntity): OrderResponse {
            return OrderResponse(
                id = entity.id,
                orderDate = entity.orderDate.toString(),
                totalPrice = entity.totalPrice,
                status = entity.status,
                items = entity.items.map { OrderItemResponse.fromEntity(it) }

            )
        }
    }
}


