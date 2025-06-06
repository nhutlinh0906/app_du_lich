package com.example.app_du_lich.api

import com.example.app_du_lich.models.Travel_Itinerary
import retrofit2.http.GET

interface TravelItineraryAPIService {
    @GET("travel_itinerary/read_travel_itinerary.php")
    suspend fun getAllTravelItineraries(): List<Travel_Itinerary>
}
