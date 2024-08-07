package org.ecommerce.lojavirtual.domain.repository

import org.ecommerce.lojavirtual.domain.entity.ProductEntity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProductRepository : JpaRepository<ProductEntity, UUID> {

    @Query("SELECT p FROM ProductEntity p LEFT JOIN FETCH p.category LEFT JOIN FETCH p.brand LEFT JOIN FETCH p.state")
    fun findAllWithDetails(): List<ProductEntity>
}
