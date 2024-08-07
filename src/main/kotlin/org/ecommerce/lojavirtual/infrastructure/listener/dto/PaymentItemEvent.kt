package org.ecommerce.lojavirtual.infrastructure.listener.dto

import java.math.BigDecimal
import java.util.UUID

data class PaymentItemEvent(
    val productId: UUID,
    val quantity: Int,
    val price: BigDecimal
)


