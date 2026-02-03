package com.acme.catalog.infrastructure.persistence.document

import com.acme.catalog.domain.model.Money
import com.acme.catalog.domain.model.Product
import com.acme.catalog.domain.model.ProductId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal


@Document(collection = "products")
data class ProductDocument(
    @Id
    val id: ProductId,
    val name: String,
    val priceAmount: BigDecimal,
    val priceCurrency: String
) {

    fun toDomain(): Product =
        Product(
            id = id.value,
            name = name,
            price = priceAmount
        )

    companion object {
        fun fromDomain(product: Product): ProductDocument =
            ProductDocument(
                id = ProductId(
                    requireNotNull(product.id) { "ProductDocument.id cannot be null" }
                ),
                name = product.name,
                priceAmount = product.price,
                priceCurrency = "€"
            )
    }
}