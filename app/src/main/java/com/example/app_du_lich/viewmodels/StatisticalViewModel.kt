package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_du_lich.models.Statistical
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StatisticalViewModel : ViewModel() {

    var statisticalList by mutableStateOf<List<Statistical>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllStatistical() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.statisticalAPIService.getAllStatistical()
                statisticalList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("StatisticalViewModel", "Lỗi khi load thống kê", e)
            } finally {
                isLoading = false
            }
        }
    }
}
