package com.example.getstartedkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform