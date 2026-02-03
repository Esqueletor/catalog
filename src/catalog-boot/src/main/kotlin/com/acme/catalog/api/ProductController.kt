package com.acme.catalog.api

import com.acme.application.useCase.CreateProductUseCase
import com.acme.catalog.api.dto.CreateProductRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/products")
class ProductController(
    private val createProductUseCase: CreateProductUseCase
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: CreateProductRequest) {
        createProductUseCase.execute(request.toCommand())
    }
}