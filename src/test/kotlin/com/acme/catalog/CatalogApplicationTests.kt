package com.acme.catalog

import com.acme.catalog.boot.CatalogApplication
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [CatalogApplication::class])
class CatalogApplicationTest {
	@Test
	fun contextLoads() {}
}