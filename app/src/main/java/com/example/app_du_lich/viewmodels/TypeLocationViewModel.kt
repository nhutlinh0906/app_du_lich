package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_du_lich.models.TypeLocation
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TypeLocationViewModel : ViewModel() {

    var typeLocationList by mutableStateOf<List<TypeLocation>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllTypeLocations() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.typeLocationAPIService.getAllTypeLocations()
                typeLocationList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("TypeLocationVM", "Error fetching type locations", e)
            } finally {
                isLoading = false
            }
        }
    }
}
