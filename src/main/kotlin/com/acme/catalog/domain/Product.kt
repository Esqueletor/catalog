package com.acme.catalog.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal

@Document("products")
data class Product(
    @Id
    val id: String? = null,
    val name: String,
    val price: BigDecimal
)