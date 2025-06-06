package com.example.app_du_lich.models
data class SystemNotification(
    var id_systemnotification: Int,
    var title_systemnotification: String,
    var content_systemnotification: String,
    var type_systemnotification: String,
    var id_user: Int?,
    var time_systemnotification: String?,
    var status_systemnotification: String?,
    var id_create_systemnotification: Int?,
    var date_systemnotification: String?
)
