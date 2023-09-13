package com.example.firstcomposemultiplatorm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform