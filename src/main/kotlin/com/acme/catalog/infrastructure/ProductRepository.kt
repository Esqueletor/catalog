package com.acme.catalog.infrastructure

import com.acme.catalog.domain.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository : MongoRepository<Product, String>
