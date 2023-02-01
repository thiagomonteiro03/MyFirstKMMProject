package com.example.getstartedkmm

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

//Located in shared/iOSMain
actual abstract class KMMViewModel {
    actual val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    actual fun dispose() {
        coroutineScope.cancel()
        onCleared()

    }

    protected actual open fun onCleared() {}
}