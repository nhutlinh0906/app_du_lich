package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_du_lich.models.Travel_Itinerary
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TravelItineraryViewModel : ViewModel() {

    var travelItineraryList by mutableStateOf<List<Travel_Itinerary>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllTravelItineraries() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.travelItineraryAPIService.getAllTravelItineraries()
                travelItineraryList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("TravelItineraryVM", "Error fetching travel itineraries", e)
            } finally {
                isLoading = false
            }
        }
    }
}
