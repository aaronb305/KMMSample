package com.example.firstcomposemultiplatorm.data

data class CoinResponse(
    val id: String,
    val symbol: String,
    val name: String,
    val current_price: Float,
    val market_cap: Int,
    val total_volume: Int,
    val high_24h: Float,
    val low_24h: Float,
    val market_cap_rank: Int
)
