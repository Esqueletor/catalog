package com.acme.catalog.config

import com.acme.application.useCase.CreateProductUseCase
import com.acme.catalog.domain.repository.ProductRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class UseCaseConfig {

    @Bean
    fun createProductUseCase(
        productRepository: ProductRepository
    ): CreateProductUseCase =
        CreateProductUseCase(productRepository)
}