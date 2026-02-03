package com.acme.catalog.infrastructure.persistence.repository

import com.acme.catalog.infrastructure.persistence.document.ProductDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface MongoProductRepository : MongoRepository<ProductDocument, String>

