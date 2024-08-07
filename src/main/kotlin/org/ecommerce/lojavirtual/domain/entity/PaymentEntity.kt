package org.ecommerce.lojavirtual.domain.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID


@Entity
@Table(name = "payments")
data class PaymentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val Id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val orderId: UUID,

    @Column(nullable = false)
    val customerId: UUID,

    @Column(nullable = false)
    val paymentId: UUID,

    @Column(nullable = false)
    val amount: BigDecimal,

    @Column(nullable = false)
    val paymentDate: LocalDateTime,

    @Column(nullable = false)
    val status: String,
)


