package org.ecommerce.lojavirtual.application.dto

import java.util.UUID

data class PaymentDto(
    val id: UUID?,
    val paymentMethod: String,
    val paymentStatus: String
)


