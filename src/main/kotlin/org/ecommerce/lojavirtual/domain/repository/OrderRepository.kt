package org.ecommerce.lojavirtual.domain.repository

import org.ecommerce.lojavirtual.domain.entity.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface OrderRepository : JpaRepository<OrderEntity, UUID>