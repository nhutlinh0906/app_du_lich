package com.example.app_du_lich.api

import com.example.app_du_lich.models.Suggest
import retrofit2.http.GET

interface SuggestAPIService {
    @GET("suggest/read_suggest.php")
    suspend fun getAllSuggest(): List<Suggest>
}
