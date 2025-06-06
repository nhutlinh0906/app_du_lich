package com.example.app_du_lich.api


import Locationn
import retrofit2.http.GET

interface LocationnAPIService {
    @GET("locationn/read_locationn.php")
    suspend fun getAllLocations(): List<Locationn>
}
