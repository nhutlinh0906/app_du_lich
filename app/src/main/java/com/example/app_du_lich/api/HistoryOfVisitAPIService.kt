package com.example.app_du_lich.api


import com.example.app_du_lich.models.History_of_visit
import retrofit2.http.GET

interface HistoryOfVisitAPIService {
    @GET("history_of_visit/read_history_of_visit.php")
    suspend fun getAllHistory(): List<History_of_visit>
}
