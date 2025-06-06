package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_du_lich.models.Schedule
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ScheduleViewModel : ViewModel() {

    var scheduleList by mutableStateOf<List<Schedule>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllSchedules() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.scheduleAPIService.getAllSchedules()
                scheduleList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("ScheduleViewModel", "Lỗi khi load lịch trình", e)
            } finally {
                isLoading = false
            }
        }
    }
}
