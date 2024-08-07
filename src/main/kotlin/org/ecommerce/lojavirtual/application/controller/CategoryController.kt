package org.ecommerce.lojavirtual.application.controller

import io.swagger.v3.oas.annotations.tags.Tag
import org.ecommerce.lojavirtual.domain.entity.CategoryEntity
import org.ecommerce.lojavirtual.domain.service.CategoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Categorias")
class CategoryController(
    private val categoryService: CategoryService
) {
    @GetMapping
    fun getAllCategories(): ResponseEntity<List<CategoryEntity>> {
        return ResponseEntity.ok(categoryService.getAllCategories())
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: UUID): ResponseEntity<CategoryEntity> {
        val category = categoryService.getCategoryById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(category)
    }

    @PostMapping
    fun createCategory(@RequestBody category: CategoryEntity): ResponseEntity<CategoryEntity> {
        val newCategory = categoryService.createCategory(category)
        return ResponseEntity.ok(newCategory)
    }

    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: UUID, @RequestBody category: CategoryEntity): ResponseEntity<CategoryEntity> {
        val updatedCategory = categoryService.updateCategory(id, category) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedCategory)
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: UUID): ResponseEntity<Void> {
        categoryService.deleteCategory(id)
        return ResponseEntity.noContent().build()
    }
}