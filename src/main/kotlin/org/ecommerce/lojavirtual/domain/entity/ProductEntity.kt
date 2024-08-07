package org.ecommerce.lojavirtual.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.UUID

@Entity
@Table(name = "products")
data class ProductEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    val id: UUID? = null,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "description")
    var description: String? = null,

    @Column(name = "price", nullable = false)
    var price: Double,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    val brand: BrandEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    val category: CategoryEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", referencedColumnName = "id")
    val state: StateEntity,

    @Column(name = "created_at")
    val createdAt: java.time.LocalDateTime = java.time.LocalDateTime.now()
)

