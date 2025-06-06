package com.example.app_du_lich.models
data class Event(
    var id_event: Int,
    var id_location: Int?,
    var name_event: String,
    var describe_event: String?,
    var date_create_event: String,
    var end_date_event: String,
    var image_event: String?,
    var organizing_unit_event: String?,
    var ticket_price_event: Double?,
    var registration_link_event: String?
)
