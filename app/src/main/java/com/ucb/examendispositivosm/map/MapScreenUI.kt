package com.ucb.examendispositivosm.map

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@SuppressLint("MissingPermission")
@Composable
fun MapScreenUI(viewModel: MapScreenViewModel = viewModel()) {
    val latitude by viewModel.latitude.collectAsState()
    val longitude by viewModel.longitude.collectAsState()

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(-17.3718, -66.1437), 15f)
    }
    val markerState = rememberMarkerState(position = LatLng(-17.3835, -66.1456))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            cameraPositionState = cameraPositionState,
            onMapClick = { latLng ->
                viewModel.updateCoordinates(latLng.latitude, latLng.longitude)
                markerState.position = latLng
            }
        ) {
            Marker(state = markerState)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Latitud: ${latitude ?: "-17.3835"}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Longitud: ${longitude ?: "-66.1456"}",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}