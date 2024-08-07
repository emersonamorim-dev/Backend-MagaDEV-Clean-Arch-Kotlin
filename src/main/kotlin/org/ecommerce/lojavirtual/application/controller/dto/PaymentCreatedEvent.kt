package org.ecommerce.lojavirtual.application.controller.dto

import java.util.UUID

data class PaymentCreatedEvent(
    val orderId: UUID,
    val customerId: UUID,
    val amount: Double,
    val status: String
)
