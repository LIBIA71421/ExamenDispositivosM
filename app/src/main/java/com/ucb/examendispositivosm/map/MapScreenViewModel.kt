package com.ucb.examendispositivosm.map

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.ViewModel

class MapScreenViewModel : ViewModel() {

    private val latitude_ = MutableStateFlow<Double?>(null)
    val latitude: StateFlow<Double?> = latitude_
    private val longitude_ = MutableStateFlow<Double?>(null)
    val longitude: StateFlow<Double?> = longitude_

    fun updateCoordinates(lat: Double, lon: Double) {
        latitude_.value = lat
        longitude_.value = lon
    }
}