package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_du_lich.models.Suggest
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuggestViewModel : ViewModel() {

    var suggestList by mutableStateOf<List<Suggest>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllSuggest() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.suggestAPIService.getAllSuggest()
                suggestList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("SuggestViewModel", "Lỗi khi load suggest", e)
            } finally {
                isLoading = false
            }
        }
    }
}
