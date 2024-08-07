package org.ecommerce.lojavirtual.domain.repository

import org.ecommerce.lojavirtual.domain.entity.BrandEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface BrandRepository : JpaRepository<BrandEntity, UUID>