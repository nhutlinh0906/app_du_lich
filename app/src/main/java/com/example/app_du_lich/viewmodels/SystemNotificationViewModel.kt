package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_du_lich.models.SystemNotification
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SystemNotificationViewModel : ViewModel() {

    var systemNotificationList by mutableStateOf<List<SystemNotification>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllSystemNotifications() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.systemNotificationAPIService.getAllSystemNotifications()
                systemNotificationList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("SystemNotificationVM", "Error fetching system notifications", e)
            } finally {
                isLoading = false
            }
        }
    }
}
