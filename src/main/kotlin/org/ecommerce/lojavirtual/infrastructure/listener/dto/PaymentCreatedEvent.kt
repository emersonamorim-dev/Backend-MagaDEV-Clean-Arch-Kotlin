package org.ecommerce.lojavirtual.infrastructure.listener.dto

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class PaymentCreatedEvent(
    val orderId: UUID,
    val customerId: UUID,
    val paymentId: UUID,
    val amount: BigDecimal,
    val paymentDate: LocalDateTime,
    val status: String
)


