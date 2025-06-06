package com.example.app_du_lich.viewmodels

import Locationn
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocationnViewModel : ViewModel() {

    var locationList by mutableStateOf<List<Locationn>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllLocations() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.locationnAPIService.getAllLocations()
                locationList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("LocationnViewModel", "Error fetching locations", e)
            } finally {
                isLoading = false
            }
        }
    }
}
