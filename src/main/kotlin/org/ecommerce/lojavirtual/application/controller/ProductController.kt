package org.ecommerce.lojavirtual.application.controller

import io.swagger.v3.oas.annotations.tags.Tag
import org.ecommerce.lojavirtual.application.controller.dto.ApiResponse
import org.ecommerce.lojavirtual.application.controller.dto.CreateProductRequest
import org.ecommerce.lojavirtual.application.controller.dto.ProductResponse
import org.ecommerce.lojavirtual.application.controller.dto.PaginationResponse
import org.ecommerce.lojavirtual.application.dto.ProductDTO
import org.ecommerce.lojavirtual.domain.entity.ProductEntity
import org.ecommerce.lojavirtual.domain.service.ProductService
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/products")
@Tag(name = "Produtos")
class ProductController(
    private val productService: ProductService
) {
    @PostMapping
    fun createProduct(@RequestBody request: CreateProductRequest): ResponseEntity<ProductResponse> {
        val savedProduct = productService.createProduct(request)
        return ResponseEntity.ok(ProductResponse.fromEntity(savedProduct))
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: UUID): ResponseEntity<ProductResponse> {
        val product = productService.findById(id)
        return ResponseEntity.ok(product)
    }

    @GetMapping
    fun listProducts(
        @RequestParam(name = "page", defaultValue = "0") page: Int,
        @RequestParam(name = "pageSize", defaultValue = "10") pageSize: Int
    ): ResponseEntity<ApiResponse<ProductResponse>> {
        val pageRequest = PageRequest.of(page, pageSize)
        val pageResponse = productService.findAll(pageRequest)
        return ResponseEntity.ok(
            ApiResponse(
                summary = mapOf("totalProducts" to pageResponse.totalElements),
                data = pageResponse.content,
                pagination = PaginationResponse.fromPage(pageResponse)
            )
        )
    }

    @GetMapping("/filter")
    fun filterProducts(
        @RequestParam(required = false) categoryId: String?,
        @RequestParam(required = false) brandId: String?,
        @RequestParam(required = false) stateId: String?
    ): ResponseEntity<List<ProductDTO>> {
        val products = productService.filterProducts(categoryId, brandId, stateId)
        return ResponseEntity.ok(products)
    }

}
