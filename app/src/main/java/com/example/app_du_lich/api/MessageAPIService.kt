package com.example.app_du_lich.api

import com.example.app_du_lich.models.Message
import retrofit2.http.GET

interface MessageAPIService {
    @GET("message/read_message.php")
    suspend fun getAllMessages(): List<Message>
}
