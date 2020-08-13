package com.github.avereshchagin.clearprice.data

data class Cart(
    var settings: CartSettings,
    val items: List<CartItem>,
    var timestamp: Long,
    var location: Location
)