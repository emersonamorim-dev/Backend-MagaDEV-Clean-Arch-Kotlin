package org.ecommerce.lojavirtual.domain.entity

import java.math.BigDecimal
import java.util.UUID
import jakarta.persistence.*

@Entity
@Table(name = "customer_items")
class CustomerItem(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    var id: UUID? = null,

    @Column(name = "product_id", nullable = false)
    var productId: UUID,

    @Column(name = "quantity", nullable = false)
    var quantity: Int,

    @Column(name = "price", precision = 19, scale = 2, nullable = false)
    var price: BigDecimal,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    var customer: CustomerEntity
)
