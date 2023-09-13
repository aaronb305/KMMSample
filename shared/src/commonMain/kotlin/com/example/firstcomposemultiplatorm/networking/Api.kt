package com.example.firstcomposemultiplatorm.networking

import com.example.firstcomposemultiplatorm.data.CoinResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

object Api {
    private val client = HttpClient()
    private const val BASE_URL = "https://api.coingecko.com/api/v3/"
    private const val ENDPOINT = "coins/markets"

    suspend fun getMarketData(): List<CoinResponse> {
        val response = client.get(BASE_URL + ENDPOINT)
        return response.body()
    }
}