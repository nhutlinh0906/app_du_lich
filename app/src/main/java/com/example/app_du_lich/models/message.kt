package com.example.app_du_lich.models
data class Message(
    var id_message: Int,
    var id_user: Int,
    var support_message: Int?,
    var content_message: String,
    var type_message: String?,
    var file_message: String?,
    var read_message: Boolean?,
    var date_message: String
)
