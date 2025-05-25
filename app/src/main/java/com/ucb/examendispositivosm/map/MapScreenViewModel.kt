package com.ucb.examendispositivosm.map

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
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
    var phone by remember { mutableStateOf("") }

    val latitude by viewModel.latitude.collectAsState()
    val longitude by viewModel.longitude.collectAsState()

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(-16.5, -68.15), 12f)
    }
    val markerState = rememberMarkerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Teléfono de referencia") }
        )

        Spacer(modifier = Modifier.height(16.dp))

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
            text = "Latitud: ${latitude ?: "No seleccionado"}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Longitud: ${longitude ?: "No seleccionado"}",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* Acción del botón */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Continuar")
        }
    }
}

