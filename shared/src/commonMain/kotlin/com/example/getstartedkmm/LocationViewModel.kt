package com.example.getstartedkmm

import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// Located in shared/commonMain
class LocationViewModel: KMMViewModel() {

    private val _address = MutableStateFlow<String?>(null)
    val address = _address.asStateFlow()

    private var loadAddressJob: Job? = null

    // Requires location permissions
    fun loadAddress() {
        loadAddressJob?.cancel()
        coroutineScope.launch {
            _address.value = LocationController().getCurrentAddress()
        }
    }
}