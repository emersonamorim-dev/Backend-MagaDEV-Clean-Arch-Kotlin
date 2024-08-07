package org.ecommerce.lojavirtual.domain.service

import org.ecommerce.lojavirtual.domain.entity.CategoryEntity
import org.ecommerce.lojavirtual.domain.repository.CategoryRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CategoryService(
    private val categoryRepository: CategoryRepository
) {
    fun getAllCategories(): List<CategoryEntity> = categoryRepository.findAll()

    fun getCategoryById(id: UUID): CategoryEntity? = categoryRepository.findById(id).orElse(null)

    fun createCategory(category: CategoryEntity): CategoryEntity = categoryRepository.save(category)

    fun updateCategory(id: UUID, category: CategoryEntity): CategoryEntity? {
        return if (categoryRepository.existsById(id)) {
            categoryRepository.save(category.copy(id = id))
        } else {
            null
        }
    }

    fun deleteCategory(id: UUID) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id)
        }
    }
}