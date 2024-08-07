package org.ecommerce.lojavirtual.infrastructure.listener.dto

import java.math.BigDecimal
import java.util.UUID

data class CustomerItemEvent(
    val itemId: UUID,
    val productId: UUID,
    val productName: String,
    val quantity: Int,
    val price: BigDecimal
)


