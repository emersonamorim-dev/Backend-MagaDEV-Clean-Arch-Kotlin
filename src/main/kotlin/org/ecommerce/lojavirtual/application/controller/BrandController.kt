package org.ecommerce.lojavirtual.application.controller
import io.swagger.v3.oas.annotations.tags.Tag
import org.ecommerce.lojavirtual.domain.entity.BrandEntity
import org.ecommerce.lojavirtual.domain.service.BrandService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/brands")
@Tag(name = "Marcas")
class BrandController(
    private val brandService: BrandService
) {
    @GetMapping
    fun getAllBrands(): ResponseEntity<List<BrandEntity>> {
        return ResponseEntity.ok(brandService.getAllBrands())
    }

    @GetMapping("/{id}")
    fun getBrandById(@PathVariable id: UUID): ResponseEntity<BrandEntity> {
        val brand = brandService.getBrandById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(brand)
    }

    @PostMapping
    fun createBrand(@RequestBody brand: BrandEntity): ResponseEntity<BrandEntity> {
        val newBrand = brandService.createBrand(brand)
        return ResponseEntity.ok(newBrand)
    }

    @PutMapping("/{id}")
    fun updateBrand(@PathVariable id: UUID, @RequestBody brand: BrandEntity): ResponseEntity<BrandEntity> {
        val updatedBrand = brandService.updateBrand(id, brand) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedBrand)
    }

    @DeleteMapping("/{id}")
    fun deleteBrand(@PathVariable id: UUID): ResponseEntity<Void> {
        brandService.deleteBrand(id)
        return ResponseEntity.noContent().build()
    }
}
