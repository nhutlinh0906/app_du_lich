package com.example.app_du_lich.api

import com.example.app_du_lich.models.Voice
import retrofit2.http.GET

interface VoiceAPIService {
    @GET("voice/read_voice.php")
    suspend fun getAllVoices(): List<Voice>
}
