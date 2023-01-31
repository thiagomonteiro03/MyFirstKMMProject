package com.example.getstartedkmm

import kotlinx.coroutines.CoroutineScope

// Located in shared/commonMain
actual abstract class KMMViewModel actual constructor() {
    actual val coroutineScope: CoroutineScope
        get() = TODO("Not yet implemented")

    actual fun dispose() {
    }

    protected actual open fun onCleared() {
    }
}