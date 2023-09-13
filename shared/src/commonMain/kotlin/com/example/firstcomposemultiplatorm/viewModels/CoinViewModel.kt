package com.example.firstcomposemultiplatorm.viewModels

import com.example.firstcomposemultiplatorm.data.CoinResponse
import com.example.firstcomposemultiplatorm.networking.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoinViewModel(
    private val repo: Repository
): ViewModel() {

//    private val _coinData: MutableStateFlow<List<CoinResponse>> = MutableStateFlow(emptyList())
//    val coinData: StateFlow<List<CoinResponse>> get() = _coinData

    val data = repo.getMarketData()

//    fun getMarketData() {
//        val newData = repo.getMarketData()
//        _coinData.update { newData }
//    }
}