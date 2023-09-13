package com.example.firstcomposemultiplatorm.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.firstcomposemultiplatorm.data.CoinResponse

@Composable
fun DetailsScreen(
    coin: CoinResponse
) {
    Surface {
        Box(
            contentAlignment = Alignment.Center
        ) {
            CoinCard(
                coin = coin,
                onClick = {  }
            )
        }
    }
}