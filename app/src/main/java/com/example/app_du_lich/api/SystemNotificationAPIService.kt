package com.example.app_du_lich.api

import com.example.app_du_lich.models.SystemNotification
import retrofit2.http.GET

interface SystemNotificationAPIService {
    @GET("systemnotification/read_systemnotification%20.php")
    suspend fun getAllSystemNotifications(): List<SystemNotification>
}
