package com.acme.catalog


import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [CatalogApplication::class])
class CatalogApplicationTest {
	@Test
	fun contextLoads() {}
}