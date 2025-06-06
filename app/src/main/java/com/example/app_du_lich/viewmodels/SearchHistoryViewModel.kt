package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import models.Search_History

class SearchHistoryViewModel : ViewModel() {

    var searchHistoryList by mutableStateOf<List<Search_History>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllSearchHistories() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.searchHistoryAPIService.getAllSearchHistories()
                searchHistoryList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("SearchHistoryViewModel", "Lỗi khi load lịch sử tìm kiếm", e)
            } finally {
                isLoading = false
            }
        }
    }
}
