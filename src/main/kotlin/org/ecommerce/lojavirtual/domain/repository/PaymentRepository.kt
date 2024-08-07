package org.ecommerce.lojavirtual.domain.repository

import org.ecommerce.lojavirtual.domain.entity.PaymentEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PaymentRepository : JpaRepository<PaymentEntity, UUID> {
    fun findAllByCustomerId(customerId: UUID, pageRequest: PageRequest): Page<PaymentEntity>
}
