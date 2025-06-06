package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_du_lich.models.Event
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EventViewModel : ViewModel() {

    // Danh sách event, observable cho Compose
    var eventList by mutableStateOf<List<Event>>(emptyList())
        private set

    // Biến trạng thái loading
    var isLoading by mutableStateOf(false)
        private set

    // Biến lỗi (nếu có)
    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllEvents() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.eventAPIService.getAllEvents()
                eventList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("EventViewModel", "Error fetching all events", e)
            } finally {
                isLoading = false
            }
        }
    }
}
