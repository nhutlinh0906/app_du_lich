package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_du_lich.models.User
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    // Danh sách user, observable cho Compose
    var userList by mutableStateOf<List<User>>(emptyList())
        private set

    // Biến để lưu trạng thái loading hoặc có thể thêm biến lỗi nếu cần
    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllUser() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.userAPIService.getAllUsers()
                userList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("UserViewModel", "Error fetching all users", e)
            } finally {
                isLoading = false
            }
        }
    }
}
