package com.example.app_du_lich.api

import com.example.app_du_lich.models.TypeLocation
import retrofit2.http.GET

interface TypeLocationAPIService {
    @GET("typelocation/read_typelocation.php")
    suspend fun getAllTypeLocations(): List<TypeLocation>
}
