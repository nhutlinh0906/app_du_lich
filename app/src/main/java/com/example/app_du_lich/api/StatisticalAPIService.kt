package com.example.app_du_lich.api

import com.example.app_du_lich.models.Statistical
import retrofit2.http.GET

interface StatisticalAPIService {
    @GET("statistical/read_statistical.php")
    suspend fun getAllStatistical(): List<Statistical>
}
