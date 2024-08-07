package org.ecommerce.lojavirtual.domain.service

import org.ecommerce.lojavirtual.domain.entity.BrandEntity
import org.ecommerce.lojavirtual.domain.repository.BrandRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class BrandService(
    private val brandRepository: BrandRepository
) {
    fun getAllBrands(): List<BrandEntity> = brandRepository.findAll()

    fun getBrandById(id: UUID): BrandEntity? = brandRepository.findById(id).orElse(null)

    fun createBrand(brand: BrandEntity): BrandEntity = brandRepository.save(brand)

    fun updateBrand(id: UUID, brand: BrandEntity): BrandEntity? {
        return if (brandRepository.existsById(id)) {
            brandRepository.save(brand.copy(id = id))
        } else {
            null
        }
    }

    fun deleteBrand(id: UUID) {
        if (brandRepository.existsById(id)) {
            brandRepository.deleteById(id)
        }
    }
}
