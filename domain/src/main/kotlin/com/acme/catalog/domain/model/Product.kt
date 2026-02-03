package com.acme.catalog.domain.model

import java.math.BigDecimal


data class Product(

    val id: String? = null,
    val name: String,
    val price: BigDecimal
)
