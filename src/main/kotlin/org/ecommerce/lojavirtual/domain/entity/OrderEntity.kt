package org.ecommerce.lojavirtual.domain.entity

import jakarta.persistence.*
import java.util.UUID
import java.math.BigDecimal
import java.time.LocalDateTime


@Entity
class OrderEntity(
    @Id
    @GeneratedValue(generator = "UUID") // Assegura que o UUID é gerado automaticamente.
    var id: UUID = UUID.randomUUID(),
    var customerId: UUID,
    var totalPrice: BigDecimal,
    var orderDate: LocalDateTime,
    var status: String,

    // Definindo o relacionamento um-para-muitos com OrderItemEntity
    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var items: Set<OrderItemEntity> = setOf()
)

