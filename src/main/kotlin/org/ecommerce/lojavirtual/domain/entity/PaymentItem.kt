package org.ecommerce.lojavirtual.domain.entity

import java.math.BigDecimal
import java.util.UUID
import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "payment_items")
data class PaymentItem(

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    var id: UUID? = null,

    @Column(name = "product_id", nullable = false)
    var productId: UUID,

    @Column(name = "quantity", nullable = false)
    var quantity: Int,

    @Column(name = "price", precision = 19, scale = 2, nullable = false)
    var price: BigDecimal,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    val payment: PaymentEntity? = null
)

