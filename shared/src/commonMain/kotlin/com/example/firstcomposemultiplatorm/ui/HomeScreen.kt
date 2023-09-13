package com.example.firstcomposemultiplatorm.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.firstcomposemultiplatorm.data.CoinResponse
import com.example.firstcomposemultiplatorm.networking.Api
import com.example.firstcomposemultiplatorm.networking.Repository
import com.example.firstcomposemultiplatorm.viewModels.CoinViewModel
import com.example.firstcomposemultiplatorm.viewModels.rememberViewModel

@Composable
fun HomeScreen(
    navigateToDetails: (CoinResponse) -> Unit
) {
    val coinViewModel: CoinViewModel = rememberViewModel { CoinViewModel(repo = Repository(Api)) }
    //coinViewModel.getMarketData(scope = scope)

    val coins by coinViewModel.data.collectAsState(initial = emptyList())

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn {
            items(coins) {coin ->
                CoinCard(
                    coin = coin,
                    onClick = navigateToDetails
                )
            }
        }
    }
}

@Composable
fun CoinCard(
    coin: CoinResponse,
    onClick: (CoinResponse) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick(coin)
            }
    ) {
        Text(text = coin.name)
        Text(text = "\$${coin.current_price}")
    }
}