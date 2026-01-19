package com.acme.catalog.application

import com.acme.catalog.domain.Product
import com.acme.catalog.infrastructure.ProductRepository
import com.acme.catalog.infrastructure.contract.dto.CreateProductRequest
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val repository: ProductRepository
) {

    fun create(request: CreateProductRequest): Product {
        val product = Product(
            name = request.name,
            price = request.price
        )
        return repository.save(product)
    }
}