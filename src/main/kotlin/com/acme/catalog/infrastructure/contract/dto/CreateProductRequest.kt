package com.acme.catalog.infrastructure.contract.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import java.math.BigDecimal

data class CreateProductRequest(
    @field:NotBlank
    val name: String,

    @field:Positive
    val price: BigDecimal
)