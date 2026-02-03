package com.acme.catalog.infrastructure.persistence.adapter

import com.acme.catalog.domain.model.Product
import com.acme.catalog.domain.repository.ProductRepository
import com.acme.catalog.infrastructure.persistence.document.ProductDocument
import com.acme.catalog.infrastructure.persistence.repository.MongoProductRepository
import org.springframework.stereotype.Component


@Component
class ProductRepositoryAdapter(
    private val mongoRepository: MongoProductRepository
) : ProductRepository {

    override fun save(product: Product): Product {
        val document = ProductDocument.fromDomain(product)
        mongoRepository.save(document)
        return product
    }

    fun findById(id: String): Product? =
        mongoRepository.findById(id)
            .map { it.toDomain() }
            .orElse(null)
}