package org.ecommerce.lojavirtual.domain.entity

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "brands")
data class BrandEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    val id: UUID? = null,

    @Column(name = "name", nullable = false, unique = true)
    val name: String
)

