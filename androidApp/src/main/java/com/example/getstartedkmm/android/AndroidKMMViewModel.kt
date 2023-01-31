package com.example.getstartedkmm.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel

// Located inshared/androidMain
abstract class KMMViewModel : ViewModel() {

    val coroutineScope = viewModelScope

    fun dispose() {
        coroutineScope.cancel()
        onCleared()
    }

    override fun onCleared() {
        super.onCleared()
    }
}