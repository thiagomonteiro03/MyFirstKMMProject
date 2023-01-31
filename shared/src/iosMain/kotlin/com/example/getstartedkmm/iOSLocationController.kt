package com.example.getstartedkmm

import platform.CoreLocation.CLGeocodeCompletionHandler
import platform.CoreLocation.CLGeocoder
import platform.CoreLocation.CLLocationManager
import platform.CoreLocation.CLPlacemark
import platform.Foundation.NSError
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

// Located in shared/iosApp
actual class LocationController {
    actual suspend fun getCurrentAddress(): String? = suspendCoroutine { continuation ->
        CLLocationManager().location?.let { location ->
            CLGeocoder().reverseGeocodeLocation(location, object : CLGeocodeCompletionHandler {
                override fun invoke(placemarks: List<*>?, error: NSError?) {
                    val clPlacemarks: List<CLPlacemark> = (placemarks as? List<CLPlacemark>?) ?: emptyList()
                    val decodedAddress = clPlacemarks.first().thoroughfare
                    continuation.resume(decodedAddress)
                }
            })
        } ?: run { continuation.resume(null) }
    }
}