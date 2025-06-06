package com.example.app_du_lich.api

import com.example.app_du_lich.models.Favourite
import retrofit2.http.GET

interface FavouriteAPIService {
    @GET("favourite/read_favourite.php")
    suspend fun getAllFavourite(): List<Favourite>
}
