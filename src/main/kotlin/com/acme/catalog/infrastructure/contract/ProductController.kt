package com.acme.catalog.infrastructure.contract

import com.acme.catalog.infrastructure.contract.dto.CreateProductRequest
import com.acme.catalog.domain.Product
import com.acme.catalog.application.ProductService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(
    private val service: ProductService
) {

    @PostMapping
    fun create(@Valid @RequestBody request: CreateProductRequest): Product =
        service.create(request)
}