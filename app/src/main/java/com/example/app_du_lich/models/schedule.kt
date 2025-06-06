package com.example.app_du_lich.models
data class Schedule(
    var id_schedule: Int,
    var id_user: String,
    var id_location: Int,
    var name_schedule: String,
    var date_create_schedule: String,
    var estimated_cost_schedule: Int?,
    var note_schedule: String?,
    var estimated_time_schedule: String?,
    var vehicle_schedule: String?,
    var number_of_greedy_people_schedule: Int?
)
