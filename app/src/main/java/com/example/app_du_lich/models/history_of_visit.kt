package com.example.app_du_lich.models

    data class History_of_visit(
    var id_history: Int,
    var id_user: Int,
    var id_locationn: Int,
    var date_history: String,
    var time_history: Int?,
    var note_history: String?,
    var evaluate_history: Int?,
    var image_history: String?,
    var creat_history: String
)


