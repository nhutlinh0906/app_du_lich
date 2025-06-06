package com.example.app_du_lich.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_du_lich.models.Voice
import com.example.lapstore.api.AppTRavelRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VoiceViewModel : ViewModel() {

    var voiceList by mutableStateOf<List<Voice>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun getAllVoices() {
        isLoading = true
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = AppTRavelRetrofitClient.voiceAPIService.getAllVoices()
                voiceList = response
                errorMessage = null
            } catch (e: Exception) {
                errorMessage = e.message
                Log.e("VoiceViewModel", "Error fetching voices", e)
            } finally {
                isLoading = false
            }
        }
    }
}
