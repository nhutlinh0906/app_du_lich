package com.example.app_du_lich.api


import models.Search_History
import retrofit2.http.GET

interface SearchHistoryAPIService {
    @GET("search_history/read_search_history.php")
    suspend fun getAllSearchHistories(): List<Search_History>
}
