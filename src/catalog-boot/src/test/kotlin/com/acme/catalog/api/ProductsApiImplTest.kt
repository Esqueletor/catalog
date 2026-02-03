package com.acme.catalog.api

import com.acme.application.command.CreateProductCommand
import com.acme.application.useCase.CreateProductUseCase
import com.acme.catalog.api.generated.model.CreateProductRequest
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertEquals


class ProductsApiImplTest (
) {


    private val useCase = mock<CreateProductUseCase>()
    private val api = ProductsApiImpl(useCase)


    @Test
    fun create() {
        // given
        val request = CreateProductRequest()
            .name("Table")
            .amount(BigDecimal("10.0"))
            .currency("EUR")

        // when ✅
        api.createProduct(request)

        // then
        val captor = argumentCaptor<CreateProductCommand>()

        verify(useCase).execute(captor.capture())

        val command = captor.firstValue
        assertEquals("Table", command.name)
        assertEquals(BigDecimal("10.0"), command.amount)
        //assertEquals("EUR", command.currency)


    }

}