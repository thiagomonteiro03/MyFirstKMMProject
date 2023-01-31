package com.example.getstartedkmm.android.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.getstartedkmm.LocationViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun LocationScreen() {
    val viewModel: LocationViewModel = viewModel()
    val address: String? by viewModel.address.collectAsStateWithLifecycle()

    val checkLocationPermission = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted: Boolean ->
            if (isGranted) {
                viewModel.loadAddress()
            }
        }
    )

    val context: Context = LocalContext.current

    LocationContent(
        address = address ?: "No address found",
        fetchCurrentLocation = {
            val coarseLocationPermission: String = Manifest.permission.ACCESS_FINE_LOCATION
            when (ContextCompat.checkSelfPermission(context, coarseLocationPermission)) {
                PackageManager.PERMISSION_GRANTED -> viewModel.loadAddress()
                else -> checkLocationPermission.launch(coarseLocationPermission)
            }
        }
    )
}