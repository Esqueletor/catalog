package com.acme.catalog.infrastructure.contract.dto

import com.acme.catalog.domain.Product
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class CreateProductRequestTest {

    @Test
    fun `create product request`() {
        //given

        //then
        val res = CreateProductRequest("jorge", BigDecimal("10.0"));

        //when
        assertThat(res.name).isEqualTo("jorge")
        assertThat(res.price).isEqualTo(BigDecimal("10.0"))

    }



}