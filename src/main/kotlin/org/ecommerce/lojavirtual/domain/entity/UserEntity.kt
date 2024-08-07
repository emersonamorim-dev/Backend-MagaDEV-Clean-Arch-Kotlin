package org.ecommerce.lojavirtual.domain.entity

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.UUID

@Entity
@Table(name = "users") // Renamed to avoid conflict with reserved SQL keyword "user"
data class UserEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    val id: UUID = UUID.randomUUID(), // Ensures a UUID is generated

    val username: String,
    val password: String,
    val email: String
)
