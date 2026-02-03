package com.acme.catalog.api.dto

import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertEquals

class CreateProductRequestTest {

    @Test
    fun `create product request`() {
        //given

        //then
        val res = CreateProductRequest("jorge", BigDecimal("10.0"), "€");

        //when
        assertEquals(res.name, "jorge")
        assertEquals(res.amount, BigDecimal("10.0"))

    }



}