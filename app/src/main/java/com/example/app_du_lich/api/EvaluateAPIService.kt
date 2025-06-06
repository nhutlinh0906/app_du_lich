package com.example.app_du_lich.api

import com.example.app_du_lich.models.Evaluate
import com.example.app_du_lich.models.User
import retrofit2.http.GET

interface EvaluateAPIService {
    @GET("evaluate/read_evaluate.php")
    suspend fun getAllEvaluate(): List<Evaluate>
}