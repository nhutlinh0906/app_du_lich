package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_du_lich.models.Message
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MessageViewModel : ViewModel() {

    var messageList by mutableStateOf<List<Message>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllMessages() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.messageAPIService.getAllMessages()
                messageList = response
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("MessageViewModel", "Error fetching messages", e)
            } finally {
                isLoading = false
            }
        }
    }
}
