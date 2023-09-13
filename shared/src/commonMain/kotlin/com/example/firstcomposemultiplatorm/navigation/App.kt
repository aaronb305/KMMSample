package com.example.firstcomposemultiplatorm.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.push
import com.example.firstcomposemultiplatorm.ui.DetailsScreen
import com.example.firstcomposemultiplatorm.ui.HomeScreen
import com.example.firstcomposemultiplatorm.ui.ListScreen
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter

@Composable
fun MainNav() {
    val router: Router<Screen> = rememberRouter(
        type = Screen::class,
        stack = listOf(Screen.Home)
    )

    RoutedContent(
        router = router,
        modifier = Modifier
    ) { screen ->
        when (screen) {
            is Screen.Home -> {
                HomeScreen(
                    navigateToDetails = { coin ->
                        router.push(Screen.Details(coin))
                    }
                )
            }
            is Screen.List -> { ListScreen() }
            is Screen.Details -> { DetailsScreen(screen.coin) }
        }

    }
}

@Composable
fun Count() {
    var count by rememberSaveable { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { count++ }
        ) {
            Text("Count: $count")
        }
    }
}
