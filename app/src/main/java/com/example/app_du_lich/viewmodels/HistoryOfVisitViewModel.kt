package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_du_lich.models.History_of_visit
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryOfVisitViewModel : ViewModel() {

    var historyList by mutableStateOf<List<History_of_visit>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllHistory() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.historyOfVisitAPIService.getAllHistory()
                historyList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("HistoryOfVisitVM", "Error fetching history", e)
            } finally {
                isLoading = false
            }
        }
    }
}
