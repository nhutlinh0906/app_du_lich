package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_du_lich.models.Favourite
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteViewModel : ViewModel() {

    // Danh sách favourite, observable cho Compose
    var favouriteList by mutableStateOf<List<Favourite>>(emptyList())
        private set

    // Biến để lưu trạng thái loading hoặc có thể thêm biến lỗi nếu cần
    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllFavourite() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.favouriteAPIService.getAllFavourite()
                favouriteList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("FavouriteViewModel", "Error fetching all favourite", e)
            } finally {
                isLoading = false
            }
        }
    }
}
