package com.example.firstcomposemultiplatorm.navigation

import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.example.firstcomposemultiplatorm.data.CoinResponse

@Parcelize
sealed class Screen(): Parcelable {
    object Home: Screen()
    object List : Screen()
    data class Details(val coin: CoinResponse) : Screen()
}
