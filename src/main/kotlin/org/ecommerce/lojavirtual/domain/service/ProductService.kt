package org.ecommerce.lojavirtual.domain.service


import org.ecommerce.lojavirtual.application.controller.dto.CreateProductRequest
import org.ecommerce.lojavirtual.application.controller.dto.ProductResponse
import org.ecommerce.lojavirtual.application.dto.BrandDTO
import org.ecommerce.lojavirtual.application.dto.CategoryDTO
import org.ecommerce.lojavirtual.application.dto.ProductDTO
import org.ecommerce.lojavirtual.application.dto.StateDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import org.ecommerce.lojavirtual.domain.entity.ProductEntity
import org.ecommerce.lojavirtual.domain.repository.*
import org.slf4j.LoggerFactory
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal
import java.util.UUID

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val brandRepository: BrandRepository,
    private val categoryRepository: CategoryRepository,
    private val stateRepository: StateRepository,
    private val orderRepository: OrderRepository
) {
    private val logger = LoggerFactory.getLogger(ProductService::class.java)

    fun createProduct(request: CreateProductRequest): ProductEntity {
        val brand = brandRepository.findById(request.brandId)
            .orElseThrow { IllegalArgumentException("Brand not found") }
        val category = categoryRepository.findById(request.categoryId)
            .orElseThrow { IllegalArgumentException("Category not found") }
        val state = stateRepository.findById(request.stateId)
            .orElseThrow { IllegalArgumentException("State not found") }

        val newProduct = ProductEntity(
            name = request.name,
            description = request.description,
            price = request.price,
            brand = brand,
            category = category,
            state = state
        )
        return productRepository.save(newProduct)
    }

    fun findById(id: UUID): ProductResponse {
        val product = productRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found") }
        return ProductResponse.fromEntity(product)
    }

    fun findAll(pageRequest: PageRequest): Page<ProductResponse> {
        val products = productRepository.findAll(pageRequest)
        return products.map { ProductResponse.fromEntity(it) }
    }

    @Transactional(readOnly = true)
    fun filterProducts(categoryId: String?, brandId: String?, stateId: String?): List<ProductDTO> {
        val allProducts = productRepository.findAllWithDetails()
        val categoryUUID = categoryId?.let { UUID.fromString(it) }
        val brandUUID = brandId?.let { UUID.fromString(it) }
        val stateUUID = stateId?.let { UUID.fromString(it) }

        logger.info("Filtrando produtos com: categoryId=$categoryUUID, brandId=$brandUUID, stateId=$stateUUID")
        logger.info("Total de produtos antes do filtro: ${allProducts.size}")

        val filteredProducts = allProducts.filter { product ->
            val matchCategory = categoryUUID == null || product.category.id == categoryUUID
            val matchBrand = brandUUID == null || product.brand.id == brandUUID
            val matchState = stateUUID == null || product.state.id == stateUUID

            logger.info("ID do produto: ${product.id}, Categoria: $matchCategory, Marca: $matchBrand, Estado: $matchState")

            matchCategory && matchBrand && matchState
        }.map { product ->
            ProductDTO(
                id = product.id!!,
                name = product.name,
                description = product.description ?: "",
                price = product.price ?: BigDecimal.ZERO,
                category = CategoryDTO(product.category.id!!, product.category.name),
                brand = BrandDTO(product.brand.id!!, product.brand.name),
                state = StateDTO(product.state.id!!, product.state.name)
            )
        }

        logger.info("Total de produtos após o filtro: ${filteredProducts.size}")
        return filteredProducts
    }
}

