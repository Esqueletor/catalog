package com.acme.catalog.api.dto

import com.acme.application.command.CreateProductCommand
import java.math.BigDecimal


data class CreateProductRequest(
    val name: String,
    val amount: BigDecimal,
    val currency: String
) {
    fun toCommand() =
        CreateProductCommand(
            name = name,
            amount = amount
        )
}