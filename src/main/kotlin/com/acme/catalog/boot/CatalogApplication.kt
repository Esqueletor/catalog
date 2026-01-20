package com.acme.catalog.boot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication( scanBasePackages = ["com.acme.catalog"])
@EnableMongoRepositories(basePackages = ["com.acme.catalog.domain"])
class CatalogApplication

fun main(args: Array<String>) {
	runApplication<CatalogApplication>(*args)
}
