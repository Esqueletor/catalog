package com.acme.catalog.domain.repository

import com.acme.catalog.domain.model.Product

interface ProductRepository {
    fun save(product: Product): Product
}
