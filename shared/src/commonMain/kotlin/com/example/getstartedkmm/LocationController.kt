package com.example.getstartedkmm

// Located in shared/commonMain
expect class LocationController() {
    suspend fun getCurrentAddress(): String?
}