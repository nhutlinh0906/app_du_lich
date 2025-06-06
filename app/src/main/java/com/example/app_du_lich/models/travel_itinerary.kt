package com.example.app_du_lich.models
data class Travel_Itinerary(
    var id_travel_itinerary: Int,
    var id_user: String,
    var name_itinerary: String?,
    var start_point_itinerary: String?,
    var end_point_itinerary: String?,
    var rest_stop_itinerary: String?,
    var vehicle_itinerary: String?,
    var distance_itinerary: Float?,
    var estimated_time_itinerary: String?,
    var update_day_itinerary: String?
)
