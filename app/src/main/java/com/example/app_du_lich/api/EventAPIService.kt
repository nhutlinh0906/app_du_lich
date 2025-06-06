package com.example.app_du_lich.api

import com.example.app_du_lich.models.Event
import retrofit2.http.GET

interface EventAPIService {
    @GET("event/read_event.php") // Đường dẫn đến file PHP lấy dữ liệu event
    suspend fun getAllEvents(): List<Event>
}
