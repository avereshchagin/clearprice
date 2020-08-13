package com.github.avereshchagin.clearprice.data

data class AppSettings(
    var baseCurrency: Currency,
    var useLocation: Boolean = true,
    var defaultTax: Double = 0.0
)