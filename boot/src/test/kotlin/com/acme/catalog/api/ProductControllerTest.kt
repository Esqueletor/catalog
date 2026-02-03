package com.acme.catalog.api

import com.acme.application.useCase.CreateProductUseCase
import com.acme.catalog.api.dto.CreateProductRequest
import com.acme.catalog.domain.model.Product
import org.assertj.core.api.Assertions.assertThat
import com.acme.catalog.CatalogApplication
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import java.math.BigDecimal
import java.util.UUID
import kotlin.test.Test
import kotlin.test.assertEquals

@SpringBootTest(classes = [CatalogApplication::class])
class ProductControllerTest(
) {

    @MockitoBean
    lateinit var createProductUseCase: CreateProductUseCase

    @Autowired
    lateinit var productController: ProductController


    @Test
    fun create() {
        //given
        val id = UUID.randomUUID().toString()
        val request = CreateProductRequest("Table", BigDecimal("10.0"), "€")
        Mockito.`when`(createProductUseCase.execute(request.toCommand()))
            .then { Product(id = id, name = "Table", price = BigDecimal("10.0")) }

        //when
        productController.create(request)


    }

}