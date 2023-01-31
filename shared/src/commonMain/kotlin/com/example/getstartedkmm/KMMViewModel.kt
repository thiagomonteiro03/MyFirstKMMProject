package com.example.getstartedkmm

import kotlinx.coroutines.CoroutineScope

// Located in shared/commonMain
expect abstract class KMMViewModel() {
    val coroutineScope: CoroutineScope
    fun dispose()
    protected open fun onCleared()
}