package com.example.app_du_lich.api

import com.example.app_du_lich.models.Notification
import retrofit2.http.GET

interface NotificationAPIService {
    @GET("notification/read_notification.php")
    suspend fun getAllNotifications(): List<Notification>
}
