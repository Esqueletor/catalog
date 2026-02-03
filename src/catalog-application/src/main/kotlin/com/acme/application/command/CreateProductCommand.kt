package com.acme.application.command

import java.math.BigDecimal

data class CreateProductCommand ( val name: String, val amount: BigDecimal){

}