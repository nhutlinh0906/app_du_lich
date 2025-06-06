package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_du_lich.models.Evaluate
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EvaluateViewModel : ViewModel() {

    // Danh sách đánh giá (evaluate)
    var evaluateList by mutableStateOf<List<Evaluate>>(emptyList())
        private set

    // Trạng thái loading
    var isLoading by mutableStateOf(false)
        private set

    // Thông báo lỗi (nếu có)
    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllEvaluate() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.evaluateAPIService.getAllEvaluate()
                evaluateList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("EvaluateViewModel", "Error fetching evaluates", e)
            } finally {
                isLoading = false
            }
        }
    }
}
