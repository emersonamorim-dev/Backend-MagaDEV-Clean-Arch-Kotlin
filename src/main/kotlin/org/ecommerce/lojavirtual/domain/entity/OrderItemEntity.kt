package org.ecommerce.lojavirtual.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.UUID

@Entity
@Table(name = "order_items")
data class OrderItemEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    val id: UUID? = null,

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "order_id", referencedColumnName = "id")
    //var order: OrderEntity? = null,


    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "order_id")
    //var order: OrderEntity? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    val product: ProductEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    var order: OrderEntity?,

    @Column(name = "quantity", nullable = false)
    val quantity: Int,

    @Column(name = "unit_price", nullable = false)
    val unitPrice: Double,
)
