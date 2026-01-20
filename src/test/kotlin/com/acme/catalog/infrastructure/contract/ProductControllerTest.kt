package com.acme.catalog.infrastructure.contract

import com.acme.catalog.application.ProductService
import com.acme.catalog.boot.CatalogApplication
import com.acme.catalog.domain.Product
import com.acme.catalog.domain.ProductRepository
import com.acme.catalog.infrastructure.contract.dto.CreateProductRequest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import java.math.BigDecimal
import java.util.UUID

@SpringBootTest(classes = [CatalogApplication::class])
class ProductControllerTest(
) {

    @MockitoBean
    lateinit var service: ProductService

    @Autowired
    lateinit var productController: ProductController


    @Test
    fun create() {
        //given
        val id = UUID.randomUUID().toString()
        val request = CreateProductRequest( "Table", BigDecimal("10.0"))
        Mockito.`when`(service.create(request))
            .then { Product( id=id, name="Table" , price = BigDecimal("10.0") ) }

        //when
        var result = productController.create(request)

        //then
        assertThat(result.name).isEqualTo("Table")
        assertThat(result.price).isEqualTo(BigDecimal("10.0"))
        assertThat(result.id).isEqualTo(id)



    }

}