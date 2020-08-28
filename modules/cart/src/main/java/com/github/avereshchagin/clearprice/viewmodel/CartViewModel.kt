package com.github.avereshchagin.clearprice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class CartViewModel(application: Application): AndroidViewModel(application) {

    val availableCurrencies = MutableLiveData<List<String>>()

    val baseCurrency = MutableLiveData<String>()

    val tax = MutableLiveData<String>()

    init {
        availableCurrencies.value = listOf(
            "RUB",
            "EUR",
            "USD",
            "SEK",
            "DKK",
            "NOK"
        )

        baseCurrency.value = "RUB"

        tax.value = "0"
    }
}