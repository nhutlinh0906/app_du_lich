package com.example.app_du_lich.api

import com.example.app_du_lich.models.Schedule
import retrofit2.http.GET

interface ScheduleAPIService {
    @GET("schedule/read_schedule.php")
    suspend fun getAllSchedules(): List<Schedule>
}
