package org.ecommerce.lojavirtual.domain.specification

import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.ecommerce.lojavirtual.domain.entity.ProductEntity
import org.springframework.data.jpa.domain.Specification
import java.util.UUID

class ProductSpecification(
    private val categoryId: UUID?,
    private val brandId: UUID?,
    private val stateId: UUID?
) : Specification<ProductEntity> {

    override fun toPredicate(root: Root<ProductEntity>, query: CriteriaQuery<*>, criteriaBuilder: CriteriaBuilder): Predicate {
        val predicates = mutableListOf<Predicate>()

        categoryId?.let {
            predicates.add(criteriaBuilder.equal(root.get<UUID>("category").get<UUID>("id"), categoryId))
        }

        brandId?.let {
            predicates.add(criteriaBuilder.equal(root.get<UUID>("brand").get<UUID>("id"), brandId))
        }

        stateId?.let {
            predicates.add(criteriaBuilder.equal(root.get<UUID>("state").get<UUID>("id"), stateId))
        }

        return criteriaBuilder.and(*predicates.toTypedArray())
    }
}
