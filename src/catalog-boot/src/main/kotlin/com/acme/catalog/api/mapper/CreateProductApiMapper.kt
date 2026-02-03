

package com.acme.catalog.api.mapper

import com.acme.catalog.api.dto.CreateProductRequest as ApiRequest
import com.acme.catalog.api.generated.model.CreateProductRequest as OpenApiRequest

object CreateProductApiMapper {

    fun fromOpenApi(request: OpenApiRequest): ApiRequest =
        ApiRequest(
            name = request.name,
            amount = request.amount,
            currency = request.currency
        )
}