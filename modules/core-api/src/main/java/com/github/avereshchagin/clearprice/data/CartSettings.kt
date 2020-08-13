package com.github.avereshchagin.clearprice.data

data class CartSettings(
    var cartCurrency: Currency,
    var tax: Double,
    var limitInBaseCurrency: Double
)