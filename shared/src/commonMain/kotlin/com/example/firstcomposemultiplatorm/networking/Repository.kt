package com.example.firstcomposemultiplatorm.networking

import com.example.firstcomposemultiplatorm.data.CoinResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository(private val api: Api) {
    fun getMarketData(): Flow<List<CoinResponse>> = flow {
        try {
            api.getMarketData()
        } catch (e: Exception) {
            emptyList()
        }
    }
}