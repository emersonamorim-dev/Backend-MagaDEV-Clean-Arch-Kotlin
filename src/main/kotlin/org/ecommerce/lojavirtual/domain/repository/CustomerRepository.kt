package org.ecommerce.lojavirtual.domain.repository

import org.ecommerce.lojavirtual.domain.entity.CustomerEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CustomerRepository : JpaRepository<CustomerEntity, UUID> {
    fun findByEmail(email: String): CustomerEntity?
}
