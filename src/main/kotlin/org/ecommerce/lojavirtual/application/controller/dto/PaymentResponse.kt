package org.ecommerce.lojavirtual.application.controller.dto

import org.ecommerce.lojavirtual.domain.entity.PaymentEntity
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class PaymentResponse(
    val Id: UUID?,
    val amount: BigDecimal?,
    val paymentDate: LocalDateTime?,
    val status: String?
) {
    companion object {
        fun fromEntity(entity: PaymentEntity): PaymentResponse {
            return PaymentResponse(
                Id = entity.Id,
                amount = entity.amount,
                paymentDate = entity.paymentDate,
                status = entity.status,

            )
        }
    }
    }

