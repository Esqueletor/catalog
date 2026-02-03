package com.acme.catalog.api

import com.acme.application.useCase.CreateProductUseCase
import com.acme.catalog.api.dto.CreateProductRequest as ApiCreateProductRequest

import com.acme.catalog.api.generated.ProductsApi
import com.acme.catalog.api.generated.model.CreateProductRequest  as OpenApiCreateProductRequest
import com.acme.catalog.api.mapper.CreateProductApiMapper
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component


@Component
class ProductsApiImpl(
    private val createProductUseCase: CreateProductUseCase
) : ProductsApi {

    override fun createProduct(
        createProductRequest: OpenApiCreateProductRequest
    ): ResponseEntity<Void> {

        val apiRequest: ApiCreateProductRequest =
            CreateProductApiMapper.fromOpenApi(createProductRequest)

        createProductUseCase.execute(apiRequest.toCommand())

        return ResponseEntity.status(201).build()
    }
}
