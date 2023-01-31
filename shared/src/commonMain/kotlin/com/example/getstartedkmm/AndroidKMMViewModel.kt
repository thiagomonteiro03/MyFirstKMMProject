package com.example.getstartedkmm

import kotlinx.coroutines.CoroutineScope

// Located in shared/commonMain
expect abstract class AndroidKMMViewModel() {
    val coroutineScope: CoroutineScope
    fun dispose()
    protected open fun onCleared()
}