package com.acme.application.useCase

import com.acme.application.command.CreateProductCommand
import com.acme.catalog.domain.model.Product
import com.acme.catalog.domain.repository.ProductRepository
import java.math.BigDecimal


class CreateProductUseCase(
    private val productRepository: ProductRepository
) {
    fun execute(cmd: CreateProductCommand) {
        val product = Product(id="22", name = "", price= BigDecimal.ZERO )
        productRepository.save(product)
    }
}